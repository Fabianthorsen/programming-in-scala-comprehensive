// Most commonly used data structure in Scala

// Different type of lists
val fruit = List("apples", "oranges", "pears")
val nums = List(1,2,3)
val diag3 =
  List(
    List(1,0,0),
    List(0,1,0),
    List(0,0,1)
  )
val empty = List()

// Two important differences to arrays:
// 1) Lists are immutable
// 2) Recursive structure (i.e. a linked list)