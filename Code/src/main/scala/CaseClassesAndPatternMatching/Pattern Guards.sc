abstract class Expr // Abstract base class
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

// Sometimes syntactic pm isnt good enough
// BinOp("+", Var(x), Var(x)) could be translated to BinOp("*", Var(x), Number(2))
def simplifyAddWrong(expr: Expr): Expr = expr match {
  case BinOp("+", x, x) => BinOp("*", x, Number(2))
  case _ => e
} // This doesnt work as we want, since x has already been used
// we have to use guards (if statements)

def simplifyAdd(expr: Expr): Expr = expr match {
  case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
  case _ => expr
}

simplifyAdd(BinOp("+", Var("x"), Var("x")))
simplifyAdd(BinOp("+", Var("x"), Var("y")))

// Match ONLY succeeds if the guard predicate is satisfied

// case n: Int if n > 0 => ... would only match positive numbers
// case s: String if s(0) == 'a' => ... only match if string starts with a