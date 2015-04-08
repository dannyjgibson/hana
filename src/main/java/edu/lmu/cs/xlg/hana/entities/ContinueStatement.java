package edu.lmu.cs.xlg.hana.entities;

/** 
* A continue statement
*/

public class ContinueStatement extends Statement {
  
  public void analyze(AnalysisContext context) {
    if (!context.isInLoop()) {
      // just continue
    }
  }
}