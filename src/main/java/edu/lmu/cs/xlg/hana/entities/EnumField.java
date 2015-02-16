package edu.lmu.cs.xlg.hana.entities;

/**
 * A field within a structure type.
 */
public class EnumField extends Entity {

    private String name;
    private int value;
    /**
     * An arbitrary field, useful in semantic analysis to take the place of a field that has not
     * been declared.  This field is type-compatible with everything, so its use serves to prevent
     * a flood of spurious error messages.
     */
    public static final enumField ARBITRARY = new EnumField("<unknown>");
    static {ARBITRARY.type = Type.ARBITRARY;}

    public EnumField(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

}
