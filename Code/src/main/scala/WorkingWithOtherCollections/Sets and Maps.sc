// Scala has both mutable and immutable implementations
// of sets and maps, but by default we get immutable implementations
import scala.collection.mutable
import scala.language.postfixOps
val mutaSet = mutable.Set(1,2,3)

// Using sets
// sets ensure that at most one of each object, as
// determined by ==, wil be contained in the set
// at any one time.
val text = "See Spot run. Run, Spot. Run!"
val wordsArray = text.split("[ !,.]+")
// To count the distinct, we can add to set
val words = mutable.Set.empty[String]
for (word <- wordsArray)
  words += word.toLowerCase

words // See, spot, run

// Other operations
val nums = Set(1,2,3)
nums + 5 // add 5, returns new set
nums - 3 // remove 3, returns new set
nums ++ List(5,6) // adds elements from list
nums -- List(1,2)
nums & Set(1,3,5,7) // Intersection
nums intersect Set(1,3,5,7) // same
nums.size
nums contains (3) // true if contained
nums | Set(1,3,4) // Union
nums union Set(1,3,4) // Same
nums &~ Set(1,3,5) // Difference
nums diff Set(1,3,5) // Same

// Using maps
val map = mutable.Map.empty[String, Int]

map("hello") = 1
map("there") = 2
map
map("hello")

// Method to count number of times each word occurs
def countWords(text: String): mutable.Map[String, Int] =
  val counts = mutable.Map.empty[String, Int]
  for (rawWord <- text.split("[ ,!.]+"))
    val word = rawWord.toLowerCase
    val oldCount =
      if (counts.contains(word)) counts(word)
      else 0
    counts += (word -> (oldCount + 1))
  counts

countWords("See Spot run! Run, Spot. Run!")

// operations for maps
val numsMap = Map("i" -> 1, "ii" -> 2)
numsMap + ("vi" -> 6) // adds 6 and returns new map
numsMap - "ii" // Remove one entry
numsMap ++ List("iii" -> 3, "v" -> 5) // add more entries
numsMap -- List("i", "ii") // remove
numsMap.size // Number of elements
numsMap.contains("ii")
numsMap("ii")
numsMap.keys // iterable keys
numsMap.keySet // set of keys
numsMap.values // Iterable values
numsMap.isEmpty

// Default sets and maps (immutable)
// For sets and maps fewer than 5 elements
// we can use a map/set of a particular size
// For sets or maps with more than 5 elements
// a HashSet or HashMap is used
// If you remove an element from Set2(_,_) you get Set1(_)

// Stored sets and maps
// May need a map whose iterator returns elements in
// a particular order
import scala.collection.immutable.{TreeSet, TreeMap}
val ts = TreeSet(9,3,1,8,0,2,7,4,6,5)
val cs = TreeSet('f', 'u', 'n')
// Sets with the ordered trait

val tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')
tm + (2 -> 'x')
tm


