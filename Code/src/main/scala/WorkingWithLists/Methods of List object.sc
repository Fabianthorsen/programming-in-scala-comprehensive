// All method until now have been methods on the Class List
// Number of methods in the globally accessible scala.List which is
// companion object of class List

// Creating lists from their elements: List.apply
List.apply(1,2,3) // same as List(1,2,3) literal

// Creating a range of numbers: List.range
// List.range(from, until)
// List.range(from, until, step)
List.range(1,5)
List.range(1,9,2)
List.range(9,1,-3)

// Creating uniform lists: List.fill
List.fill(5)('a')
List.fill(3)("hello")

// if fill is given more than two arguments, it will make
// a multidimensional list
List.fill(2,3)('b') // 2 lists, with 3 elements

// Tabulating a function: List.tabulate
// Creates a list whose elements are computed according to supplied method
val squares = List.tabulate(5)(n => n * n)
val multiplication = List.tabulate(5,5)(_ * _)

// Concatenating mulitple lists: List.concat
List.concat(List('a','b'), List('c','d'))
List.concat(List(), List('b'), List('c'))
List.concat() // Empty list


