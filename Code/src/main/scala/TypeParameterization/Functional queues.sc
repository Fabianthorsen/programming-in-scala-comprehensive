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

trait Queue[T]{
  def head: T
  def tail: Queue[T]
  def enqueue(x: T): Queue[T]
}

object Queue {
  // Construct a queue with initial elemets xs
  def apply[T](xs: T*) = new Queue(xs.toList, Nil)

  // Have rest of implementation here to hide rest
  // of class implementation
  private class QueueImpl[T](
    private val leading: List[T],
    private val trailing: List[T]
  ) extends Queue[T] {
    // The larger the queue, the less mirror will be called
      private def mirror =
        if (leading.isEmpty) new QueueImpl(trailing.reverse, Nil)
        else this

      // T* means that the parameter is repeated
      // def this(elems: T*) = this(elems.toList, Nil) // Auxiliary constructor
      // rather make a companion object and a factory method

      def head = mirror.leading.head
      def tail: QueueImpl[T] = {
        val q = mirror
        new QueueImpl(q.leading.tail, q.trailing)
      }
      def enqueue(x: T) = new QueueImpl(leading, x :: trailing)
  }
  // trying to use Queue as a type wont work since it is a
  // trait, but Queue[String] is a type

  // Queue[+T] would mean that subtyping is covariant
  // Queue[-T] would mean that subtyping is contravariant
  // A lot of covariant in functional world, but not mutable world

}
