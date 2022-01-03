// The only available control structures are:
// if, while, for, try, match and function calls
// All control structures result in some value

val args = Array("Test.txt")

// Imperative style of if:
var filename = "defaults.txt"
if (!args.isEmpty) {
  filename = args(0)
}
filename

// Scala style of if:
val filename =
  if (!args.isEmpty) args(0)
  else "default.txt"

// val helps tell the reader that the variable will never change
// val also better supports equational reasoning.
// Meaning that every time you are about to write the varaible name
// you could instead write the expression such as:
println(if (!args.isEmpty) args(0) else "default.txt")
// instead of:
println(filename)