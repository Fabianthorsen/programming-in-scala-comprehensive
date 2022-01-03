// Dont need to use semicolons, unless two expression on same line
val s = "hello"; println(s);

val x = 10; val y = 20
// Expression below is parsed to x.+(y)
x
+ y

// Also correctly parsed:
x +
  y

// Rules of semicolon inference:
/*
* A line ending is treated as a semicolon unless one of the
* following conditions are true:
* 1. The line in question ends in a word that would not be
* legal as the end of a statement, such as a period or an infix operator
* 2. The next line begins with a word that cannot start a statement
* 3. The line ends while inside parentheses (...) or brackets [...],
* because these cannot contains multiple statements anyway
* */
