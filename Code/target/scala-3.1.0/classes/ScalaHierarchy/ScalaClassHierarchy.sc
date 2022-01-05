/* Scala's class hierarchy
final def ==(that: Any): Boolean
final def !=(that: Any): Boolean
def equals(that: Any): Boolean
def ##: Int
def hashCode: Int
def toString: String
*/

new Int // Throws since Int is abstract
// Int methods
42.toString
42.hashCode
42 equals 42

// An instance of scala.Int is widened to
// scala.Long when needed

42 max 43
42 min 43
1 until 5
1 to 5
3.abs
-3.abs

// Methods min, max, until, to and abs are
// defined in a class scala.runtime.RichInt
// Uses an implicit conversion
// AnyRef is an alias for java.lang.Object

