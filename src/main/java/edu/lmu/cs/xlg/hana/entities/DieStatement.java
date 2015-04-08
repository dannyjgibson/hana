package edu.lmu.cs.xlg.hana.entities;

/**
* The Die statement.
*/
public class DieStatement extends Statement {
  private Expression status;

  public DieStatement(Expression status) {
    this.status = status;
  }

  public Expression getStatus() {
    return this.status;
  }

  @Override
  // do I need context? I kinda think I can just
  // print to stderr and break the whole program
  public void analyze(AnalysisContext context) {
    System.err.println(this.status);
    context.error("die");
  }
}