// Steps to recognizing the difference to other styles of code:
// - Code containing "var" often means it is in an imperative style
// - No "var" is what is the norm in functional style

// Example
// Non-functional implementation:
def printArgs(args: Array[String]): Unit =
  var i = 0
  while(i < args.length) {
    println(args(i))
    i += 1
  }

// Can be transformed into:
def printArgsFunc(args: Array[String]): Unit =
  for (arg <- args){
    println(arg)
  }

// Or to this:
def printArgsCond(args: Array[String]): Unit =
  args.foreach(println)

printArgs(Array("o", "i", "l"))
printArgsFunc(Array("o", "i", "l"))
printArgsCond(Array("o", "i", "l"))

// These methods are not purely funcitonal since they have sideeffects
def formatArgs(args: Array[String]): String =
  args.mkString("\n")

// Same input as above, but with a pure function
println(formatArgs(Array("o", "i", "l")))

// Reason for least amount of side-effects:
// Better testability of code
val res = formatArgs(Array("zero", "one", "two"))
assert(res == "zero\none\ntwo") // Throws if wrong


