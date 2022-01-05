// Mapping over lists: map, flatMap and foreach
// xs map f takes as operands a list of xs of type List[T] and a function f T => U
// it returns the result from mapping f to each element of xs
List(1,2,3) map (_ + 1) // increment all by one
val words = List("the", "quick", "brown", "fox")
words map (_.length) // List[String] -> List[Int]
words map (_.toList.reverse.mkString) // reverses each word

// flatMap is similar to map, but takes a function returning a list of elements
// as its right operand. Then applies function to each elements and returns
// the concatenation of all function results
words map (_.toList) // List[List[Char]]
words flatMap (_.toList) // List[Char]

List.range(1,5) flatMap(
  i => List.range(1, i) map (j => (i,j))
)
// Constructs all pairs (i,j) such that 1 <= j < i < 5
// List.range creates a list of all integers in some range
// First used to create a list of integers 1 until 5 (exclusive)
// Second used to generate list of integers from 1 to i
// could also have used a for-expression
for (i <- List.range(1, 5); j <- List.range(1,i)) yield (i,j)

// foreach takes a procedure as right operand and applies the procedure to each element
var sum = 0
List(1,2,3,4,5) foreach (sum += _)
sum

// Filtering list: filter, partition, find, takeWhile, dropWhile and span
// xs filter p takes xs of List[T] and predicate p T => Boolean, yield all
// xs for which p(x) is true
List(1,2,3,4) filter(_ % 2 == 0) // evens
words filter (_.length == 3) // only words of length 3

// partition is like filter but returns a pair of lists
// xs partition p == (xs.filter p, xs filter (!p(_)))
val (evens, odds) = List(1,2,3,4) partition (_ % 2 == 0) // One list of evens, one list of odds

// Find method is similar to filter but returns the FIRST element that satifsy
// the given predicate. It returns optional value
List(1,2,3,4,5) find (_ % 2 == 0) // first even element in list
List(1,2,3,4,5) find (_ <= 0) // First element less or equal to 0

// takeWhile and dropWhile also take predicate as right operand
// xs takeWhile p takes the longest prefix of list xs, such that every
// element satisfy p
// xs dropWhile p removes the longest prefix from list xs such that every
// element satisfy p
List(1,2,3,-4,5) takeWhile (_ > 0) // All positive elements untill first negative
words dropWhile (_ startsWith "t") // Drops until "the"

// xs span p == (xs takeWhile p, xs dropWhile p)
List(1,2,3,-4,5) span (_ > 0)

// Predicates over lists: forall and exists
// xs forall p takes a list xs and a predicate p
// true if all elements of xs satisfy p
// xs exists p takes a list xs and a predicate p
// true if there is an element that satisfy p
def hasZeroRow(m: List[List[Int]]): Boolean =
  m exists (row => row forall (_ == 0))

val diag3: List[List[Int]] =
  List(
    List(1,0,0),
    List(0,1,0),
    List(0,0,1)
  )
hasZeroRow(diag3)

// Folding lists: foldLeft and foldRight
// sum(List(a,b,c)) equals 0 + a + b + c
// special instance of a fold operation
def sum(xs: List[Int]): Int = xs.foldLeft(0)(_ + _)
sum(List(1,2,3))

def product(xs: List[Int]): Int = xs.foldLeft(1)(_ * _)
product(List(1,2,3))

// A fold left operation xs.foldLeft(z)(op) takes three objects:
// "z"  start value, list "xs" and a binary operation "op"
// Result of fold is op applied between successive elements of the list
// prefixed by z, for instance:
// List(a,b,c).foldLeft(z)(op) equals op(op(op(z, a), b), c)
// sum(sum(sum(0, 1), 2), 3) -> sum(sum(1, 2),3) -> sum(3,3) -> 6

words.foldLeft("")(_ + " " + _) // ends up with a leading space
// op(op(op(op("" + " " + "the"), ...),"fox")
// op(op(op(" the" + " " + "quick"), ...),"fox")
// ...
// op(" the quick brown" + " " + "fox")

words.tail.foldLeft(words.head)(_ + " " + _)
// This time it starts with "the"
// op(op(op("the" + " " + "quick"),...),"fox")

// right fold operation xs.rightFold(z)(op)
// (List(a,b,c).rightFold(z)(op) equals op(a, op(b, op(c, z)))
words.foldRight("")(_ + " " + _) // will have a trailing space
// op("the",op(...,op("fox" + " " + "")
// op("the",op(...,op("quick" + " " + "fox ")
// ...
// op("the" + " " + "quick brown fox ")

words.init.foldRight(words.last)(_ + " " + _)
// this starts with "fox" as z
// op("the", op(...,(op("quick" + " " + "fox")
// ...
// op("the" + " " + "quick brown fox")

// For associative operations foldLeft and foldRight are equivalent
// but might be different in efficiency
def flattenLeft[T](xss: List[List[T]]) =
  xss.foldLeft(List[T]())(_ ::: _)

def flattenRight[T](xss: List[List[T]]) =
  xss.foldRight(List[T]())(_ ::: _)

// Flatten right is more efficient since flattenLeft copies the first
// element xss.head n - 1 times
flattenRight(List(List(1,2,3), List(4,5,6))) // More efficient
flattenLeft(List(List(1,2,3), List(4,5,6)))

// Example: List reversal using fold
def reverseLeft[T](xs: List[T]) = xs.foldLeft(List[T]()){(ys, y) => y :: ys}
val rev = reverseLeft(List(1,2,3))
// Applies a constant time operation n times, so O(n), linear time complexity

// Sorting lists: sortWith
// xs sortWith before, xs is a list, and before is a function
// that compares two elements,
// x before y should return true if x should come before y
List(1,-3,4,2,6) sortWith (_ < _) // smaller to larger

words sortWith (_.length > _.length) // Longer to shorter words