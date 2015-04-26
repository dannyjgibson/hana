package edu.lmu.cs.xlg.hana.entities;

/** 
* A conditional simple statement.
*/

public class ConditionalSimpleStatement extends Statement {

  private Statement simpleStatement;
  private Expression condition;
  private String control;

  public ConditionalSimpleStatement(Statement simpleStatement, Expression condition, String control) {
    this.simpleStatement = simpleStatement;
    this.condition = condition;
    this.control = control;
  }

  public Statement getSimpleStatement() {
    return simpleStatement;
  }

  public Expression getConditionalExpression() {
    return condition;
  }

  public String getControl() {
    return control;
  }

  @Override
  public void analyze(AnalysisContext context) {
    if (control.equals("if")) {
      condition.analyze(context);
      condition.assertBoolean("if_condition_not_boolean", context);
      simpleStatement.analyze();
    } else if (control.equals("while")) {

    } else if (control.equals("unless")) {

    } else { // control equals until

    }

    
  }

  @Override
  public Statement optimize() {
    if ((control.equals("while") || control.equals("if")) && condition.isFalse()) {
      // "while false"" or "if false" are both no-ops
      return null;
    }
    if ((control.equals("unless") || control.equals("until")) && condition.isTrue()) {
      // "unless true" or "until true" are both no-ops
      return null
    }
    return this;
  }
}