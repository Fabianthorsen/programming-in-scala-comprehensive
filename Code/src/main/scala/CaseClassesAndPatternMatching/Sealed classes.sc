sealed abstract class Expr // Abstract base class
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

// when doing PM we need to cover all possible cases
// What if there is no default?
// - A sealed class cannot have subclasses added except ones
// in the same file
// This helps the compiler know if there are uncovered cases
// in the pattern matching
// Good practice if the classes are going to be pattern matched

def describe(e: Expr): String = e match {
  case Number(_) => "a number"
  case Var(_) => "a var"
  // If we stopped with the two above we get a
  // match may not be exhaustive error and which
  // cases we would miss
  case _ => throw new RuntimeException // Catchall method that should not happen
}
// Above with the catch all is not idea

def betterDescribe(e: Expr): String = (e: @unchecked) match {
  case Number(_) => "a number"
  case Var(_) => "a var"
}
// This now works as it does not check for all combinations