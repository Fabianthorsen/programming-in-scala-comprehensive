// A function queue is a ds with three ops:
// 1) head, 2) tail, 3) enqueue
// enqueue returns a new queue with a given element appended at the end

// Functional queues does not change its content when an element is appended
// A new queue is returned that contains the element

// Ideally, a functional queue should now have a fundamentally higher
// overhead than an imperative (mutable) queue. Meaning the ops should
// operate in constant time.

class SlowAppendQueue[T](elems: List[T]){// Not efficient
  def head = elems.head
  def tail = elems.tail
  def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x))
}
// The main problem is the enqueue operation which has to traverse
// the list in order to append the element
// Constant time append you can try to reverse the order
class SlowHeadQueue[T](smele: List[T]) { // Not efficient
  def head = smele.head
  def tail = smele.tail
  def enqueue(x: T) = new SlowHeadQueue(x :: smele)
}
// enqueue is constant time, but head and tail are not
// head and tail are now O(N) linear time operations

// By combining the two operations we can get very close
// Idea to represent a queue by two lists, called leading and trailing
// Leading - Element towards the front
// Trailing - Element toward the black in reverse order
// contents of the queue are now leading ::: trailing.reverse
// Now to append we just cons :: and thus enqueue will be constant time

class Queue[T](
  private val leading: List[T],
  private val trailing: List[T]
) {
  // The larger the queue, the less mirror will be called
  private def mirror =
    if (leading.isEmpty) new Queue(trailing.reverse, Nil)
    else this

  def head = mirror.leading.head
  def tail = {
    val q = mirror
    new Queue(q.leading.tail, q.trailing)
  }
  def enqueue(x: T) = new Queue(leading, x :: trailing)
}

