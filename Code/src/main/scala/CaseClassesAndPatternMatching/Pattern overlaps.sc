abstract class Expr // Abstract base class
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

// Patterns are tried in the order they are written

def simplifyAll(expr: Expr): Expr = expr match {
  // Simplification rules
  case UnOp("-", UnOp("-", e)) => simplifyAll(e) // its own inverse
  case BinOp("+", e, Number(0)) => simplifyAll(e)
  case BinOp("*", e, Number(1)) => simplifyAll(e)
  // Basecases
  case UnOp(op, e) => UnOp(op, simplifyAll(e))
  case BinOp(op, l, r) => BinOp(op, simplifyAll(l), simplifyAll(r))
  case _ => expr
}
// Method above will perform simplification for all parts
// of the expression
// Applying simplifyAll recursively unill the potential basecases are met
// Either one of the last three are basecases
// Simplification rules come before the base cases

simplifyAll(BinOp("*", Var("x"), BinOp("+", Var("x"), Number(0))))

