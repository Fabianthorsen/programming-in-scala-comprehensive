package FunctionalObjects

import scala.annotation.tailrec
import scala.language.implicitConversions

// Running example throughout the chapter

// n - numerator, d - denominator are called class parameters
// In Scala, parameters are taken directly, unlike in Java where classes have constructors
class Rational(n: Int, d: Int) {
  // Checking for preconditions: denominator cannot be 0
  require(d != 0)

  // Private fields and methods
  private val g = gcd(n.abs,d.abs) // Absolute value to make sure g is always positive

  // Make class parameters available to all members
  // Make class parameters into fields
  // These are also called initializers, since they initialize a variable
  val numer: Int = n / g // Normalized with the greatest common divisor
  val denom: Int = d / g // Normalized with the greatest common divisor

  // Auxiliary constructor for when create instance from a whole number, i.e. Rational(5) = 5/1
  def this(n: Int) = this(n, 1)

  // Reimplementing the toString since toString inherits java.lang.Object implementation of toString
  // Do this to improve prints, logs, test reports and interpreter/debugger output
  override def toString = s"$numer/$denom"
  
  

  // Adding fields
  // Create a public add method to add another Rational object and return a new Rational with the sum
  def +(that: Rational): Rational =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  // Method overloading - be able to use + on more than one type
  def +(i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def -(that: Rational): Rational =
    new Rational(numer * that.denom - that.numer * denom, denom * that.denom)

  def -(i: Int): Rational =
    new Rational(numer - i * denom, denom)

  def *(that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def *(i: Int): Rational =
    new Rational(numer * i, denom)

  def /(that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  def /(i: Int): Rational =
    new Rational(numer, denom * i)

  // Add gcd to be able to normalize the Rationals, but dont want everyone to access this method
  @tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a
    else gcd(b, a % b)

  // Use self reference to specify parameters from THIS instance
  def lessThan(that: Rational): Boolean = this.numer * that.denom < that.numer * this.denom
  def lessThan(i: Int): Boolean = this.numer < i * this.denom

  // Above we did not have to use this, but an example of where we MUST use this is
  def max(that: Rational): Rational = if (this.lessThan(that)) that else this
  def max(i: Int): Rational = if (this.lessThan(i)) new Rational(i, 1) else this
}
