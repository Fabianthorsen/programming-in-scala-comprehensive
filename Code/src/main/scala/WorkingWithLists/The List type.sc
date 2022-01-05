// Lists are homogenous, meaning they can only contain one type for all elements
// A list with elements of type T are written List[T]

val fruits: List[String] = List("apples", "oranges", "pears")
val nums: List[Int] = List(1,2,3)
val diag3: List[List[Int]] =
  List(
    List(1,0,0),
    List(0,1,0),
    List(0,0,1)
  )
val empty: List[Nothing] = List() // Empty list is list of nothing

// List type in Scala is covariant:
// For each pair of types S and T, if S is a subtype of T, the List[S] is a
// subtype of List[T]. For instance List[String] is a subtype of List[Object].
// List[Nothing] is a bottom-type so a subtype of everything
val xs: List[String] = List() // Empty list is a empty list of strings although no elements
