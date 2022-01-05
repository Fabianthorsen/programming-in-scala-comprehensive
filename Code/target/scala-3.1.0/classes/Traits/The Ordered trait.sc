import scala.annotation.tailrec

// Comparison is another domain where a rich interface is convenient
// Assuming we want to implement comparison for Rational class
// Using an ordered trait to get comparison
class Rational(n: Int, d: Int) extends Ordered[Rational]{
  require(d != 0)

  private val g = gcd(n.abs, d.abs) // Absolute value to make sure g is always positive

  val numer: Int = n / g // Normalized with the greatest common divisor
  val denom: Int = d / g // Normalized with the greatest common divisor

  def this(n: Int) = this(n, 1)

  override def toString = s"$numer/$denom"
  @tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a
    else gcd(b, a % b)

  // Have to implement compare method because ordered trait
  def compare(that: Rational) =
  // Should return int 0 if equal, negative if less and positive if greater
    (this.numer * that.denom) - (this.denom * that.numer)
}

// Ordered trait defines <, >, <= and >=
val half = new Rational(1,2)
val third = new Rational(1,3)

// This works due to our compare method and ordered trait
third < half
half >= third