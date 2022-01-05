// Example with library for manipulating artithmetic
// expressions
// First step for tackling: definition of the input data
// We only think of variables, number, unary and binary operations

abstract class Expr // Abstract base class
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

// Each sub-class has a case modifier
// Makes compiler add syntactic convenience to the class

// 1) It adds a factory methods
// No need to use new keyword
val v = Var("x")
val op = BinOp("+", Number(1), v)

// 2) All parameters get prefixed with val
v.name
op.left

// 3) Compiler adds natural implemetation on toString,
// hashCode and equals methods
println(op)
op.right == Var("x")

// 4) Compiler adds a copy method for making modified copies
op.copy(operator="-")

// Case classes have no downside else than being slightly larger,
// and having the case modifier
// Biggest advantage is that they support pattern matching

// Pattern Matching
def simplifyTop(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) => e // Double negation
  case BinOp("+", e, Number(0)) => e // Adding zero
  case BinOp("*", e, Number(1)) => e // Multiplying by one
}

simplifyTop(UnOp("-", UnOp("-", Var("x")))) // -(-(Var(x)) is just Var(x)
simplifyTop(BinOp("+", Var("x"), Number(0))) // Just Var(x) since add 0 does nothing

// Differnece from Switch statements
/*
* - PM is an expression, meaning it returns a value
* - Scala alternatives never "fall through" into the next case
* - If no patterns are matched throws MatchError
* */



