// What if we want to implement something like if or while, where we dont pass
// any value into the code between the curly braces?
// Help using by-name parameters
// Concrete example: myAssert which takes a function value as input, and
// consult a flag to decide what to do
// without by-name params it looks like:
var assertionsEnabled = true
def myAssert(predicate: () => Boolean): Unit =
  // If we assert, and the predicate is false
  if (assertionsEnabled && !predicate())
    throw new AssertionError

myAssert(() => 5 > 3)
myAssert(() => 5 < 3) // Throws AssertionError
myAssert(5 > 3) // does not work since its not a function call

// By-name parameters exists so that we can do this.
def byNameAssert(predicate: => Boolean): Unit =
  if (assertionsEnabled && !predicate)
    throw new AssertionError

// Can now leave the parentheses
byNameAssert(5 > 3)
byNameAssert(5 < 3) // throws AssertionError

// Why can we not simply do this?
def boolAssert(predicate: Boolean): Unit =
  if (assertionsEnabled && !predicate)
    throw new AssertionError

// It does work
boolAssert(5 > 3)
boolAssert(5 < 3)
// But since the parameter is boolean the expression 5 > 3 is evaluated BEFORE
// the call to boolAssert
// By contrast, inside byNameAssert the 5 > 3 is not evaluated before it is called
// inside the function body
// If assertionsEnabled is false, we will see any side effects that boolAssert
// may have, but not in byNameAssert since it will never be called inside the body

val x = 5
assertionsEnabled = false
boolAssert(x / 0 == 0) // throws ArithmeticException since expression is evaluated
byNameAssert(x / 0 == 0) // Doesnt do anything since assertionsEnabled = false
