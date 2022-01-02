// Maps and set have both mutable and immutable implementations
// Creating an immutable set with a var
var jetSet = Set("Boeing", "Airbus")
jetSet += "Lear"
println(jetSet.contains("Cessna")) // True if contains element, else false

// Creating a mutable set as a val
val movieSet = scala.collection.mutable.Set("Hitch", "Poltergeist")
movieSet += "Shrek"
println(movieSet)

val hashSet = scala.collection.immutable.HashSet("Tomatoes", "Chillies")
println(hashSet + "Coriander")

// Creating maps
// Mutable map
val treasureMap = scala.collection.mutable.Map[Int, String]()
treasureMap += (1 -> "Go to island")
treasureMap += (2 -> "Find big X on ground")
treasureMap += (3 -> "Dig.")
println(treasureMap(2))

// Immutable map with other construction syntax
val romanNumeral = Map(
  1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
)

println(romanNumeral(4))
