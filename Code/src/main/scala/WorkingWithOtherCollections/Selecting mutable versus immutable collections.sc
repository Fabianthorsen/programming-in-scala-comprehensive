// When in doubt, start with immutable, then change if needed
// Immutable collections are usually more compactly stored than mutable

// Syntactic sugar to switch between
val people = Set("Nancy", "Jane")
people += "Bob" // Will not work

var people1 = Set("Nancy", "Jane")
people1 += "Bob" // now works
people1
people1 -= "Jane"
people1 ++= List("Tom", "Harry")
people1

// This is useful like here
var capital = Map("US" -> "Washington", "France" -> "Paris")
capital += ("Japan" -> "Tokyo")
println(capital("France"))
// COde uses immutable collections

