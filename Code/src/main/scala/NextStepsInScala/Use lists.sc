// Lists are immurable, arrays are mutable
val oneTwoThree = List(1,2,3)
oneTwoThree(1) = 4 // Throws error
val fourFiveSix = 4 :: 5 :: 6 :: Nil // Cons notation
// Operator notation is right associative, meaning:
// For a * b will be same as a.*(b), left associative
// While for 1 :: rest will be rest.::(1), right associative
// Nil == List(), the empty list
// Nil.::(6.::(...(4)) is what happens above, and why we need Nil

val allNums = oneTwoThree ::: fourFiveSix // Concatenate

// Example of list ops
val thrill = "Will" :: "fill" :: "untill" :: Nil
thrill.mkString(", ") // Returns string repr, with ", " as sep
thrill.filter(s => s.length == 4) // Filter only those matching predicate
// Sort with a predicate
thrill.sortWith((s,t) => s.charAt(0).toLower < t.charAt(0).toLower)
thrill.tail // Tail element(s)
thrill.head // Head element
thrill.isEmpty // True if empty, else false



