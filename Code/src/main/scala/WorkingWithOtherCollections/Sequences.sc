// Lists
// Immutable linked list
val colors = List("red", "blue", "green")
colors.head
colors.tail

// Arrays
// Mutable and efficiently accessed
val fiveInts = new Array[Int](5) // New array of 5 inegers
val fiveToOne = Array(5,4,3,2,1) // New array with the elements
fiveInts(0) = fiveToOne(4) // Mutable
fiveInts

// List buffers
// List provide fast access to head, but not end
// Mutable and appends to end with +=
import scala.collection.mutable.ListBuffer
val buf = new ListBuffer[Int]
buf += 1
buf += 2
buf
3 +=: buf // prepend
buf.toList

// Array buffers
// Like an array but can add and remove from beginning and end
// Constant time operations, may require linear time due to implementation
import scala.collection.mutable.ArrayBuffer
val abuf = new ArrayBuffer[Int]()
abuf += 12 // append
abuf += 15
abuf
abuf.length
abuf(0)

// Strings (via StringOps)
def hasUpperCase(s: String): Boolean = s exists (_.isUpper)
hasUpperCase("Robert Frost")
hasUpperCase("e e cummings")
// Exists is invoked on the string named s, String class itself
// does not have a method named exists

