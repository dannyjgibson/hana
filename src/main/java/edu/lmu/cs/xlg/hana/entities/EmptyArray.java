package edu.lmu.cs.xlg.hana.entities;
import java.util.List;

/**
 * An empty array expression, for example:
 * <ul>
 * <li>new int[30]
 * <li>new boolean[3]
 * </ul>
 */

public class EmptyArray extends Expression {

    private String tyname;
    private Expression bound;
    private List<Expression> bounds;

    public EmptyArray(String tyname, Expression bound) {
        this.tyname = tyname;
        this.bound = bound;
    }

    public EmptyArray(String tyname, List<Expression> bounds) {
        this.tyname = tyname;
        this.bounds = bounds;
    }

    public Expression getBound() {
        return bound;
    }

    public String getTyname() {
        return tyname;
    }

    public void analyze(AnalysisContext context) {
        type = context.lookupType(tyname);
        if (bound != null) {
            bound.analyze(context);
            bound.assertInteger("new_array_allocation", context);
        } else if (bounds != null || !bounds.isEmpty()) {
            for (int i = 0; i < bounds.size(); i++) {
                Expression boundArrayElement = bounds.get(i);
                boundArrayElement.analyze(context);
                boundArrayElement.assertInteger("new_array_allocation", context);
            }
        }
        type = type.array();
    }
}
