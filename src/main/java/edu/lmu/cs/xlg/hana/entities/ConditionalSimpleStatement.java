package edu.lmu.cs.xlg.hana.entities;

/** 
* A conditional simple statement.
*/

public class ConditionalSimpleStatement extends Statement {

  private Statement simpleStatement;
  private Expression conditionalExpression;

  public ConditionalSimpleStatement(Statement simpleStatement, Expression conditionalExpression) {
    this.simpleStatement = simpleStatement;
    this.conditionalExpression = conditionalExpression;
  }

  public Statement getSimpleStatement() {
    return simpleStatement;
  }

  public Expression getConditionalExpressio() {
    return conditionalExpression;
  }

  @Override
  public void analyze(AnalysisContext context) {
    
  }

}