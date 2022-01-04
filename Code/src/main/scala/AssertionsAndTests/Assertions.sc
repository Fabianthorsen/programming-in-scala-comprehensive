// Written as calls of a predefined method assert
// Throws AssertionError if condition does not hold
// Type of explanation is Any
// Assert method will call toString to get string interpolation

def division(x: Int, y: Int): Int =
  assert(y != 0)
  x / y

