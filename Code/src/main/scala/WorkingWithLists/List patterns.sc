// Can also be used for pattern matching
// Can either match the all elements of a list using List(...), or
// take list apart bit by bit using patterns composed from :: operator

val fruits = List("apples", "oranges", "pears")
val List(a,b,c) = fruits

// if we didnt know length of list, better to use ::
val d :: e :: rest = fruits

// Rewriting insertion sort with pattern matching
def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y :: ys => if (x <= y) x :: xs
                  else y :: insert(x, ys)
}
def isort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case x :: xs1 => insert(x, isort(xs1))
}

val nums = List(2,67,2,3,5,23,1,32,4)
isort(nums)
