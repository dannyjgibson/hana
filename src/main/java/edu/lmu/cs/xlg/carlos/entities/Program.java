package edu.lmu.cs.xlg.hana.entities;

import java.util.List;

/**
 * A Hana program.  Programs in Hana are just blocks whose symbol table's parent is the
 * global table containing the built-in types and functions.
 */
public class Program extends Block {

    public Program(List<Statement> statements) {
        super(statements);
    }
}
