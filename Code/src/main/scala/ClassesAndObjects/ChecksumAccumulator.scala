package ClassesAndObjects

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
