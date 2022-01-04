// Second major use of traits: providing stackable
// modifications to classes

abstract class IntQueue {
  def get(): Int
  def put(x: Int): Unit
}

// Specify a trait to modify the queue class
// Since doubling extends IntQueue we can only
// add it to subclasses of IntQueue, not f.ex. Rational
trait Doubling extends IntQueue {
  // to use super, we have to have other concrete implementation first
  // super in a trait is dynamically bound
  abstract override def put(x: Int): Unit = { super.put(2 * x) }
}

import scala.collection.mutable.ArrayBuffer
class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int): Unit = { buf += x }
}

val queue = new BasicIntQueue
queue.put(10)
queue.put(20)
queue.get()
queue.get()

class MyQueue extends BasicIntQueue with Doubling

val doubleQueue = new MyQueue
doubleQueue.put(10)
doubleQueue.get() // We get 20, which is double of what we put in

// can mix in traits when defining an instance
val dbQueue = new BasicIntQueue with Doubling
dbQueue.put(20)
dbQueue.get()

// More stackable traits
trait Incrementing extends IntQueue {
  abstract override def put(x: Int): Unit = { super.put(x + 1) }
}
// will only put positive values
trait Filtering extends IntQueue {
  abstract override def put(x: Int): Unit = {
    if (x >= 0) super.put(x)
  }
}

val stackedQueue = new BasicIntQueue with Incrementing with Filtering
stackedQueue.put(-1); stackedQueue.put(0); stackedQueue.put(1)
stackedQueue.get() // Get back one, since -1 isn't put, and 0 is incremented once
stackedQueue.get()

// Order of mixing is significant
val switchedQueue = new BasicIntQueue with Filtering with Incrementing
switchedQueue.put(-1); switchedQueue.put(0); switchedQueue.put(1)
switchedQueue.get() // Now we Increment first, then filter. Thus -1 -> 0 and is OK for the filter
switchedQueue.get()

// Overall rule: Traits further to the right take effect FIRST






