val big = new java.math.BigInteger("12345678910111213141516")

// Not recommended way to create array
val greetingString = new Array[String](3) // String array with three elements

// val itself cannot be changed, but the elements inside can
// Mutability
greetingString(0) = "Hello" // equivalent to greetingString.update(0, "Hello")
greetingString(1) = ", "
greetingString(2) = "world.\n"

for (i <- 0 until greetingString.length) {
  println(greetingString(i)) // Same as greetingString.apply(i)
}

// Explicitly specify the type of array
val otherGreeting: Array[String] = new Array[String](3)

// Equivalent ways of creating a new array
val numNames = Array("one", "two", "three")
val numNames2 = Array.apply("one", "two", "three")

