package edu.lmu.cs.xlg.hana.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A type which is an enumeration.
 */
public class EnumType extends Type {

    private List<EnumField> fields;

    public EnumType(String name, List<EnumField> fields) {
        super(name);
        this.fields = fields;
    }

    public List<EnumField> getFields() {
        return fields;
    }

    @Override
    public void analyze(AnalysisContext context) {
        Set<String> enumNames = new HashSet<String>();
        for (EnumField field: fields) {
            if (! enumNames.add(field.getName())) {
                context.error("duplicate_field", field.getName(), this.getName());
            }
        }

        for (EnumField field: fields) {
            field.analyze(context);
        }
    }

    /**
     * Returns the field in this type with the given name.  If no
     * such field exists, log an error and return an "arbitrary" field.
     */
    public EnumField getField(String fieldName, AnalysisContext context) {
        for (EnumField field: fields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }

        // Didn't find it, use the placeholder.
        context.error("no_such_field", this.getName(), fieldName);
        return EnumField.ARBITRARY;
    }
}
