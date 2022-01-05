// Scala has a Option type which is used when there may or may not be a value
// Option has two forms: Some(x) where x is the actual value, a None for no value

// An example could be when checking a map
// if the given key has been found return Some(value) else None
val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
// Get method returns an Option
capitals get "France" // this return Some(Paris)
capitals get "Norway" // Returns None

def show(x: Option[String]): String = x match {
  case Some(s) => s
  case None => "?"
}

show(capitals get "France")
show(capitals get "Norway")

// Alot less error prone than Null in Java
