// Similar to switch statements, match expressions let you select from a number of alternatives
// Use arbitrary patters
val args = Array("chips")

val firstArg = if (args.length > 0) args(0) else ""

// Constant match pattern
firstArg match { // Match expression with side effects
  case "salt" => println("pepper")
  case "chips" => println("salsa")
  case "eggs" => println("bacon")
  case _ => println("huh?")
}

// Most significant difference to switch is that it results in a value
val friend = // Without side effects
  firstArg match {
    case "salt" => "pepper"
    case "chips" => "salsa"
    case "eggs" => "bacon"
    case _ => "huh?"
  }

println(friend)