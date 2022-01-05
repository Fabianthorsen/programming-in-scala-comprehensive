sealed abstract class Expr // Abstract base class
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

// Patterns take many parts in Scala, not just match expressions

// Patterns in variable definitions
// Can use a pattern instead of a simple indentifier when
// creating a val or a var
val myTuple = (123, "abc")
val (number, string) = myTuple // PM under the hood
number

// Deconstruct anything with a pattern
val exp = BinOp("*", Number(5), Number(1))
val BinOp(op, left, right) = exp

// Case sequences as partial functions
// A case sequence is a function literal, only more general
val withDefault: Option[Int] => Int = {
  case Some(x) => x
  case None => 0
}

withDefault(Some(10))
withDefault(None)

// Another generalization worth noting: sequences of cases
// gives you partial function
// Write it as a PartialFunction type as well, becuase
// then we only need to supply cases for which it is
// defined at
val second: PartialFunction[List[Int], Int] = {
  case x :: y :: _ => y
}

second(List(1,2,3))
second(List(1)) // Match error since its not defined for it

second.isDefinedAt(List(1)) // Not defined for it
second.isDefinedAt(List(1,2,3)) // Defined for it

// The literal above gets translated under the hood to
new PartialFunction[List[Int],Int] {
  def apply(xs: List[Int]) = xs match {
    case x :: y :: _ => y
  }
  def isDefinedAt(xs: List[Int]) = xs match {
    case x :: y :: _ => true
    case _ => false
  }
}

// Better to work with complete functions due to runtime errors
// that compiler cannot help with

// Patterns in for-expressions
// get the pair from a map for each entry
val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

for ((country, city) <- capitals) {
  println(s"The capital of $country is $city")
}

// might not match a generated value
val result = List(Some("apple"), None, Some("orange"))
for (Some(fruit) <- result) println(fruit) // Only prints the Some(_)



