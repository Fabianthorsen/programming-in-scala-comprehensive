// Encapsulates method and field definitions, and can be used in mixing
// into classes
trait Philosophical {
  def philosophize(): Unit = println("I consume memory, therefore I am")
}
// Does not declare superclass, so superclass is AnyRef

class Animal
trait HasLegs

// Can now mix the trait into classes
// Can mix both inheritance and multiple traits
class Frog extends Animal with Philosophical with HasLegs {
  override def toString = "green"
  // And override implementation of trait methods
  override def philosophize() = {
    println(s"I ain't easy being $toString!")
  }
}

val frog = new Frog
frog.philosophize() // now has this method

val phil: Philosophical = frog
phil.philosophize()
// The type of phil is a trait, philosophical

// Traits can do much more than java interfaces
