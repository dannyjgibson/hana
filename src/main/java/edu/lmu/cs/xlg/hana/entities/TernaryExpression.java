package edu.lmu.cs.xlg.hana.entities;

/** 
* Ternary Expression, evaluates a boolean, and depending on the value
* of that boolean, exclusively evaluates one of the two final expressions
*/

public class TernaryExpression extends Expression {
  private Expression condition; 
  private Expression trueOption; 
  private Expression falseOption;

  public TernaryExpression(Expression condition, Expression trueOption, Expression falseOption) {
    this.condition = condition;
    this.trueOption = trueOption;
    this.falseOption = falseOption;
  }

  public Expression getCondition() {
    return this.condition;
  }

  public Expression gettrueOption() {
    return this.trueOption;
  }
  
  public Expression getfalseOption() {
    return this.falseOption;
  }

  @Override
  public void analyze(AnalysisContext context) {
    // how to tell if condition is true?
    // check for all the truthy values in Hana?
    if (condition instanceof BooleanLiteral) { // and true, right?
      this.trueOption.analyze(context);
    } else {
      this.falseOption.analyze(context);
    }
  }
}