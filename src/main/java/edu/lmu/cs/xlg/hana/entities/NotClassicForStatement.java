package edu.lmu.cs.xlg.hana.entities;

/**
 * A statement of the form "for id(expression of type array) block"
 */

public class NotClassicForStatement extends Statement {

  private String index;
  private Expression range;
  private Block body;

  public NotClassicForStatement(String index, Expression range, Block body) {
    this.index = index;
    this.range = range;
    this.body = body;    
  }

  public String getIndex() {
    return this.index;
  }

  public Expression getRange() {
    return this.range;
  } 

  public Block getBody() {
    return this.body;
  }

  @Override
  public void analyze(AnalysisContext context) {

    // range must be an expression of type Array
    if (range != null) {
      range.analyze(context);
      range.assertArray("nonclassic_for_loop_termination_not array", context);     
    } 

    body.analyze(context.withInLoop(true));
  }

} 