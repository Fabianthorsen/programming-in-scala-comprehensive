// Traits can enrich "thin" interfaces, making it into a rich interface
// Represents a commonly faced trade-off in OO design
// Rich interfaces have a lot of methods but difficult to use
// Thin interfaces have few methods but are easy to use

// Defining a thin trait like CharSequence from Java 1.4
trait CharSequence {
  def charAt(index: Int): Char
  def length: Int
  def subSequence(start: Int, end: Int): CharSequence
  def toString: String
}

// Rich interfaces are less work to implement in Scala than Java
// To enrich an interface, define a trait with a small number of
// abstract methods, the thin part of the traits interface, and
// a potentially large number of concrete methods, all implemented
// in terms of the abstract methods.