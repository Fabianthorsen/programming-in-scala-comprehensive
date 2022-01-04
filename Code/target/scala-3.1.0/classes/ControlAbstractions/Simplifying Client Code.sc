// Another important use of HOFs - Put them in an API to make client code easier
// Example with method to check for negative numbers
def containsNeg(nums: List[Int]): Boolean =
  var exists = false
  for (num <- nums)
    if (num < 0) exists = true
  exists

containsNeg(List(-1,4,3,2))
containsNeg(List(1,2,3,4))

// More concise way to write it
def containsPos(nums: List[Int]): Boolean = nums.exists(_ > 0)

containsPos(Nil)
containsPos(List(1,2,3))

// Another example
def hasEven(nums: List[Int]): Boolean =
  var exists = false
  for (num <- nums)
    if (num % 2 == 0) exists = true
  exists

// Or more concisely
def containsEven(nums: List[Int]): Boolean = nums.exists(_ % 2 == 0)

containsEven(List(3,5,7))
hasEven(List(3,5,7))

