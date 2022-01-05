// A method is first-order if it does not take any functions as arguments

// Concatenating two lists using :::
List(1,2) ::: List(3,4,5)
List() ::: List(1,2,3)
List(1,2,3) ::: List(4)
// xs ::: ys ::: zs == xs ::: (ys ::: zs) like with cons ::

// Divide and conquer principle
// call it append
def append[T](xs: List[T], ys: List[T]): List[T] =
  // Can only append lists of same type
  xs match {
    case List() => ys
    case x :: xs1 => x :: append(xs1, ys)
  }

append(List(1,2,3), List(4,5,6))

// Length method on lists
List(1,2,3).length // relatively expensive on lists
// Because it needs to traverse the whole list to get length
// this is why xs.isEmpty is better than xs.length == 0

// Accessing the end of a list with init and last
val abcde = List('a','b','c','d','e')
abcde.last // Last element of list
abcde.init // All except last element
List().init // exception
List().last // Also exception

// Unlike head and tail which are O(1) methods, init and last are O(N) since they
// need to traverse the whole list to get the result

// Reversing lists
abcde.reverse

// Reverse, init and last satisfy some laws for reasoning:
// 1) reverse is its own inverse
abcde.reverse.reverse
// 2) reverse turns init into tail and last to head
abcde.reverse.init == abcde.tail.reverse
abcde.reverse.tail == abcde.init.reverse
abcde.reverse.head == abcde.last
abcde.reverse.last == abcde.head

// Could implement reverse as a contanating method
def rev[T](xs: List[T]):List[T] = xs match {
  case List() => xs
  case x :: xs1 => rev(xs1) ::: List(x)
}
rev(List(1,2,3))
// This method however is less effective than we want,
// total complexity of rev is O(1 + N * N / 2) meaning O(N^2) at worst
// Standard reversal is O(N)

// Prefixes and suffixes: drop, take and splitAt
// for take and drop, if n > list.length the whole list is returned
// xs take n returns first n elements of xs
// xs drop n returns all elements of list except for first n
// xs splitAt i splits the list at the given index i returning a pair of
// two lists, xs splitAt i equals (xs take i, xs drop i)

val nums = List(1,2,3,4)
nums take 2
nums drop 2
nums splitAt 2

// Element selection: apply and indices
nums apply 2 // very rare in scala
nums(2) // is still rare in scala
// Less popular for lists since xs(n) takes O(N)
// xs apply n equals (xs drop n).head

// Indices returns a list of indexes in the list as a range
nums.indices

// Flattening a list of lists|
// flatten takes a list of lists and returns a list
List(List(1,2), List(3), List(), List(4,5)).flatten
val fruits = List("apples", "oranges", "pears")
fruits.flatMap(_.toCharArray) // Both a map and a flatten operation
List(1,2,3).flatten // Doesnt work since only for List of list
// ALL ELEMENTS must be lists

// Zipping lists with zip and unzip
// zip takes two lists and forms a list of pairs
val abc = List('a','b','c')
abc.indices zip abc
// So much used that it has its own method
abc.zipWithIndex // Equivalent to above

// Can only be zipped with equal length list
val zipped = abc zip List(1,2,3)
zipped.unzip // returns a pair of two lists'
val (chars, numbers) = zipped.unzip

// Displaying lists with toString and mkString
abc.toString // returns canonical string repr of a list

// If want other repr we use xs mkString(pre, sep, post)
// results: pre + xs(0) + sep + ... + sep + xs(xs.length - 1) + post
// two overloaded methods: xs mkString sep == xs mkString ("", sep, "")
// or: xs.mkString == xs mkString ""

abc mkString ("[", ",", "]")
abc mkString ""
abc.mkString
abc mkString ", "

// Also variant of the mkString method called addString in the StringBuilder
val buf = new StringBuilder
abc addString (buf, "(", "; ", ")")

// Converting lists: iterator, toArray, copyToArray
val arr = abc.toArray // to array
arr.toList // back to list

val arr2 = new Array[Int](10)
// xs copyToArray (arr, start)
List(1,2,3) copyToArray (arr2, 3)
arr2

val it = abc.iterator // Converts it to an iterator
it.next
it.next

// Example: Merge sort
// Merge sort works as follows:
/*
* 1) If list has zero or one elements, it is already sorted
* 2) Longer lists are split into sub-lists, containing about half elements than original
* 3) Each sub-list is sorted by a recursive call to the sort function
* */

// Complexity of mergesort is O(n log(n)), less drop in efficiency for longer lists
def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
  def merge(xs: List[T], ys: List[T]): List[T] =
    (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (less(x,y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }
  val n = xs.length / 2
  if (n == 0) xs
  else {
    val (ys, zs) = xs splitAt n
    merge(msort(less)(ys), msort(less)(zs))
  }
}

println(msort((x: Int, y: Int) => x < y)(List(1,6,23,15,343,21,64,7623)))

val intSort = msort((x: Int, y: Int) => x < y)_ // Partial application
intSort(List(5,2,4,1,7,5))




