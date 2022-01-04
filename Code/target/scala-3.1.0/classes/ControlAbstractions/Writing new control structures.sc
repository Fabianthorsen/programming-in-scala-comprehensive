import scala.language.postfixOps

// Need to create methods that take functions as parameters
def twice(op: Double => Double, x: Double): Double = op(op(x))
twice(_ + 1, 5) // will do ((5 + 1) + 1)

// Loan pattern
// Opens a resource and "loans" it to a function

println("Hello, World")
println{"Hello, World"}

// Both above are equivalent for one param, but multiple with fail
val g = "Hello, World"
g.substring(7,9)
g.substring{7,9} // Throws an error

// with {} only the last argument passed in will be passed in to the function
// Often write <function name>(param: Type)(operation function): Type
// def withPrintWriter(file: File)(op: PrintWriter => Unit)
// And thus when it is invoked it will look something like this:
// withPrintWriter(file) {writer => ...}, looking more natural