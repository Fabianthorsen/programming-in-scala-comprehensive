/*
* An object defined with the object keyword. Each singleton object has one and only one instance.
* A singleton object that shares its name with a class, and is defined in the same source file as that class,
* is that class’s companion object. The class is its companion class.
* A singleton object that doesn’t have a companion class is a standalone object
* */

// A way scala is more OO than Java is that Scala cannot have Static members.
// Example: Our singleton is called ChecksumAccumulator
// Called companion class to the object
class ChecksumAccumulator {
  private var sum = 0 // can be accessed from companion object
  def add(b: Byte): Unit = { sum += b }
  def checksum(): Int = ~(sum & 0xFF) + 1
}

import scala.collection.mutable
// Also called a companion object to the class
object ChecksumAccumulator {
  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int = {
    if (cache.contains(s)) cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)

      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
  }
}