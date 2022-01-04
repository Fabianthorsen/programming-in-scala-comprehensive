// Functions can be written as literals
// (x: Int) => x + 1 is a literal that adds 1 to a number

val increase = (x: Int) => x + 1
increase(10) // same as increase.apply(10)

// Use function literals to print all elements from collection
val someNumbers = List(-11, -10, -5, 0, 5, 10, 11)
someNumbers.foreach((x: Int) => println(x))
someNumbers.foreach(println) // Equivalent to above

// Filter method
someNumbers.filter((x: Int) => x > 0) // Only positive numbers

// Short form of function literals
someNumbers.filter(x => x < 0) // Type is inferred
// This is called target typing because the targeted
// usage of an expression is allowed to influence
// the typing of that expression

// Placeholder syntax
someNumbers.filter(_ < 0)
// Can only be used if:
// - The parameter only appear once
// - When compiler needs more information about type
// val f = _ + _ does not compile
val f = (_: Int) + (_:Int) // does work
f(10, 15)

// Partially applied function
def sum(a: Int, b: Int, c: Int): Int = a + b + c
sum(1,2,3) // Just a regular function

val a = sum _
// a is now (Int, Int, Int) => Int
// such that:
a(1,2,3) // = 6
// Equivalent to a.apply(1,2,3)

val b = sum(1, _: Int, 3)
// b is now Int => Int
b(2) // Is thus = 6
// b.apply(1,2,3)

// Closures
val more = 1

val addMore = (x: Int) => x + more
addMore(10) // works as long as more is bound
// The function value created at runtime is called
// a closure. It arises from the act of "closing" the
// function literal by "capturing" the bindings of its
// free variables.
// (x: Int) => x + 1 is called a closed term, where
// term is a bit of source code
// (x: Int) => x + more has a free variable "more", and
// is called an open term.
// This thus requires a binding of its free variables
// to be captured

def makeIncreaser(more: Int) = (x: Int) => x + more

val inc1 = makeIncreaser(1)
val inc9999 = makeIncreaser(9999)

inc1(10) // Uses more = 1
inc9999(10) // Uses more = 9999

// When makeIncreaser is called, a closure is created
