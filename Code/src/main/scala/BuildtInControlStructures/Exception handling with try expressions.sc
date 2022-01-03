// A method can be terminated by throwing an exception
// caller can then either catch and handle the exception or
// it can simply terminate, which then propagates to the callers caller

// Throwing exceptions
throw new IllegalArgumentException

val n = 3
val half = // will throw since 3 isn't even
  if (n % 2 == 0)
    n / 2
  else
    throw new RuntimeException("n must be even")

// catching exceptions
try {
  val f = n / 0
} catch {
  case ex: ArithmeticException => println("Cannot divide by 0")
}

// Finally clause
try {
  val f = n / 0
} catch {
  case ex: ArithmeticException => println("Cannot divide by 0")
} finally {
  println("I will always print")
}

// Yielding a value
import java.net.URL
import java.net.MalformedURLException
def urlFor(path: String) =
  try {
    new URL(path)
  } catch {
    case e: MalformedURLException => new URL("http://www.scala-lang.org")
  }

urlFor("https://vg.no")
urlFor("vg.no")

// Given this contrived, function definition
def f(): Int = try return 1 finally return 2
f() // Returns 2
// while
def g(): Int = try 1 finally 2
g() // returns 1

// Finally usually does some form of cleanup
// Example above shows why we dont return values from finally clause