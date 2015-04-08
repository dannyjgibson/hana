package edu.lmu.cs.xlg.hana.entities;

/** 
* A conditional statement.
*/

public class ConditionalStatement extends Statement {

  private Statement simpleStatement;
  private Expression conditionalExpression;

  public ConditionalStatement(Statement simpleStatement, Expression conditionalExpression) {
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