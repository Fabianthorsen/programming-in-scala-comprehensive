// Constant Patterns
// Any literal may be used as a constant pattern
def describe(x: Any): String = x match {
  case 5 => "five"
  case true => "true"
  case Nil => "the empty list!"
  case "Hello" => "hi"
  case _ => "something else"
}

describe(5)
describe(Nil)
describe(List(1,2,3))

// Variable patterns
// Matches any object, but unlike wildcard it binds the
// variable to WHATEVER the object is
import math.{E, Pi}
E match { // This will work since Pi is already a bound variable
  case Pi => s"Strange math? Pi = $Pi"
  case _ => "OK" // Just a wildcard match
}

val pi = Pi
E match {
  case pi => s"Strange math? Pi = $pi" // This isn't correct
  // Lexical rule: lowercase letters are taken to be
  // pattern variables, other references are constants
}

// Can use back-ticks trick
E match {
  case `pi` => s"Strange math? Pi = $pi"
  case _ => "OK" // Will now match this
}

// Constructor patterns

/*
* expr match {
*   case BinOp("+", e, Number(0)) => println("a deep match")
*   case _ =>
* */

// Does not only check top level object, but also the contents

// Sequence Patterns

/*
* expr match {
*   case List(0, _, _) => println("found it")
*   case _ =>
* */

// This would check for a three-element list starting with 0
// Can alternatively use _* to not specify length

/*
* expr match {
*   case List(0, _*) => println("found it")
*   case _ =>
* */

// This would check for any list starting with 0

// Tuple patterns
def tupleDemo(expr: Any) =
  expr match {
    case (a,b,c) => println(s"Matched $a$b$c")
    case _ =>
  }

tupleDemo((1,2,3))
tupleDemo((1,2,3,4)) // No match since too long
tupleDemo(("a ", 3,"-tuple"))

// Typed patterns
def generalSize(x: Any) = x match {
  case s: String => s.length // if x is a string
  case m: Map[_, _] => m.size // if x is a map
  case _ => -1 // else
}

generalSize("abc")
generalSize(Map(1 -> 'a', 2 -> 'b'))
generalSize(math.Pi)

// Type Erasure
// Cannot check for a map of particular types as they
// get erased at runtime, so no information aboute type
// is kept at runtime, and thus cannot be checked for
def isInIntMap(x: Any) = x match {
  case m: Map[Int, Int] => true
  case _ => false
}

// Only valid for arrays
def isStringArray(x: Any) = x match {
  case a: Array[String] => "yes"
  case _ => "no"
}

isStringArray(Array("abc"))
isStringArray(Array(1,2,3))

// Variable binding
def variableBinding(x: Any) = x match {
  case (_, a @ 3, _) => a // bind 3 to variable a with @
  case _ =>
}

variableBinding((1,2,3))
variableBinding((2,3,1))