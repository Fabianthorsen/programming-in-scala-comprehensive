// Class Int contains method named +, that take Int => Int
val sum = 1 + 2
val sumMore = 1.+(2) // Equivalent

// Int contains several overloaded + methods that take different types
val longSum = 1 + 2L // 1.+(2L) Long => Long

// The symbol + is an operator, an INFIX operator
// Other methods are also available
val s = "Hello, World!"
s indexOf "o" // s.indexOf("o")

// Overloaded indexOf method
// indexOf(char, index to start)
s indexOf ("o", 5)

// Infix operators sit between the object and the parameter
// Prefix operators are put before the object it is being invoked on
// Postfix operators are put after the object it is being invoked on
// Prefix and Postfix are unary, meaning they only take one parameter

// Prefix
-8

// Postfix
8.toLong
// With unary notation
(2.0).unary_- // Prefix notation is now postfix

