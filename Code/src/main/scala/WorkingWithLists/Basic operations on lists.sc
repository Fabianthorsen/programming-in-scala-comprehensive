// All operations on lists can be expressed in terms of the following:
// head - returns the first element of the list
// tail - returns the rest of the elements except head
// isEmpty - returns true if list is empty

Nil.head // NoSuchElementException since it is empty
// head, tail are only defined for non-empty lists

Nil.isEmpty // True since empty
val fruits = "apples" :: "pears" :: "oranges" :: Nil
fruits.isEmpty // false since it contains elements
fruits.head // Just first element
fruits.tail // All elements after head
fruits.tail.head // second element

// Insertion sort in scala code
def isort(xs: List[Int]): List[Int] =
  def insert(x: Int, xs: List[Int]): List[Int] =
    if (xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)
  if (xs.isEmpty) Nil
  else insert(xs.head, isort(xs.tail))

val nums = List(2,6,3,1,5,7)
isort(nums)

