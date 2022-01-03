// Determines which parts of an expression are evaluated before the other parts
// 2 + 2 * 7 evaluates to 16, not 28, because the * operator has a higher
// precedence than then +. Can use parentheses to clarify the expression
(2 + 2) * 7 // will be 28
2 + 2 * 7 // will be 16
2 + (2 * 7) // equivalent to above

/* Operator precedence (Higher up, higher precedence)
* * / %
* + -
* :
* = !
* < >
* &
* ^
* |
* (all letters)
* (all assignment operators)
* */

2 << 2 + 2 // 2 << (2 + 2)
2 << 4 // same since (2 + 2) is evaluated before <<
2 + 2 << 2 // since same as 4 << 2

// x *= y + 1 would be x *= (y + 1)

// When multiple operators of the same precedence appear side by side in
// an expression, the associativity of the operator determines the way
// operators are grouped. Associativity is determined by its LAST character
// Methods that end in a ":" is invoked on its right operand, passing in the left operand
// a * b yields a.*(b), but a ::: b yields b.:::(a)
// If a is an expression that is not just a simple reference to an immutable block
// then a ::: b is more precisely treated as: { val x = a; b.:::(x) }
// a ::: b ::: c would be treated as a ::: (b ::: c),
// while a * b * c is treated as (a * b) * c
