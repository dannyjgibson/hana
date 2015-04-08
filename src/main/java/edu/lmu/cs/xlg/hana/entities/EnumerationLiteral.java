package edu.lmu.cs.xlg.hana.entities;

/**
* An enumeration literal
*/

public class EnumerationLiteral extends Literal {

    String type;
    String literal;

    public EnumerationLiteral(String type, String literal) {
      super(literal);
      this.type = type;
    }

    public String getEnumType() {
      return this.type;
    } 

    public String getLiteral() {
      return this.literal;
    }

    @Override 
    public void analyze(AnalysisContext context) {

    }

    
}