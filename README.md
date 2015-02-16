
# A Compiler for the Hana Programming Language

Hana is a little (bit bigger than Carlos as a) programming language, similar in size to C, but with automatic memory management.

The language is described in detail [here](http://cs.lmu.edu/~ray/notes/hana/).

## Some Differences between Carlos and Hana

Hana has enumerations. 
  * An identifier declared as a literal of an enumeration type has the scope of the type itself. 
  * Identifiers withing a particular enumeration type declaration myst be unique among themselves.
  * The only values of an enumeration are the ones declared for it.
  * Enumerations are primitive types.

Hana has Stream types.

Hana has Thread types.
  * Threads can  prevent programs from dying -- instead, threads die!

Hana has *variadic* functions.
  * A variadic function's parameter list ends in "..."

Hana has volatile variables
  * If a variable is marked `volatile`, then changes to the variable in one thread must be visible to other threads that may access the variable. 

Hana has a constant keyword
  * hana also has non-writable variables though!

Hana has slice variables
  * They look like `v[e1...e2]`
  * Slice variables are derived from `v`, an array or string.
  * Slice variables are new arrays or strings whose first elementis at `v[max(e1,0)]`, and last element is `v[min(e2, length(v) - 1)]`.
  * If e1 > length(v) - 1 or e1 > e2, the slice variable is an empty array or string.

Hana has continue statements
  * These only appear within a while or for statement that is properly within the same function as the continue statement. The continue statement terminates the current iteration of the innermost enclosing while or for statement. 

Hana has die statements
  * Die statements look like `die e;`
  * `e` is a string that is written to standard error.
  * The current thread dies.

 Hana doesn't have print statements

 Hana has an alternative For statement
   * Alternative syntax is `for i (a) b`
   * `a` must be an array expression.
   * `i` is a new variable in scope `b`. 
   * `b` is executed one for each value of `i` in the range of `a`.

Hana has some syntactic sugar sprinkled in its conditionals and loops
  * `s if e`
    * If `e` is true, executes `s`.
  * `s unless e`
    * If `e` is false, executes `s`.
  * `s while e`
    * If `e` is true, executes `s`. Then executes the entire statement again.
  * `s until e`
  	* Executes `s`, then evaluates `e`. If the `e` is true, the statement completes.

Hana has *enumeration literal* expressions 
  * Enumertion literals look like `T :: x`
  * `T` is the enumeration type, `x` is the literal of that type

Hana has array based object construction
  * This looks like `new t [e1] [e2] ... [en]`
  * Refers to a newly constructed array of `en`  items, each of which is a newly constructed array of `en - 1` items of type `t`.

Hana has Thread Construction
  * This looks like `start f (e1, ... , en);`
  * Spawns a thread that runs `f` with arguments `e1` through `en` 

Hana has some syntactic sugar sprinkled into its expressions
  * `#e` returns the length of an array or string `e`
  *  `$e` produces a string representation of `e`, which is any expression.

Hana has a conditional operator style ternary operator.

Hana has different set of built-in functions.   