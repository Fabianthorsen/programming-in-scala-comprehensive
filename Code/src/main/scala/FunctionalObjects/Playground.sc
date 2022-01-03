import FunctionalObjects.Rational

val x = new Rational(1,2)
val y = new Rational(5,7)

// This should not work
new Rational(5,0)

// Test add member
val oneHalf = Rational(1,2)
val oneThird = Rational(1,3)
oneHalf + oneThird * oneHalf
oneHalf + (oneThird * oneHalf)
(oneHalf + oneThird) * oneHalf // Operator precedence still works

oneHalf max oneThird
oneHalf lessThan oneThird

// Using the auxiliary constructor
val five = Rational(5)

// Test overloaded methods
val z = Rational(4,2)
z + 2
z lessThan 1
z * 5
z - 2
z max 4

// Implicit conversion so that 2 * r works as r * 2 would
// has to be defined in the scope, and inside class would be outside scope
implicit def intToRational(x: Int): Rational = new Rational(x)
5 * z // Testing the implicit conversion
5 - z


