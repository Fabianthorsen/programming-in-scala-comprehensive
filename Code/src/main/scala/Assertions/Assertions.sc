def divideAssert(n: Double, d: Double): Double =
  assert(d != 0)
  n / d

divideAssert(1,0) // AssertionError since division by zero
divideAssert(1,2)

// Can also use ensuring, which is more concise
def divideEnsure(n: Double, d: Double): Double = {
  n / d
} ensuring (d != 0)

divideEnsure(1,0) // Throws AssertionError
divideEnsure(1,2)

// Assertions can be turned off in the JVM
