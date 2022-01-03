// Class is a blueprint for objects
class ChecksumAccumulator {
  // Implementation
  // Fields and methods are reffered to as members
  var num = 0 // Field or instance variable
  private var sum = 0 // can only be access here
  def add(b: Byte): Unit = { sum += b }
  def checksum(): Int = ~(sum & 0xFF) + 1
}

// Create ned instances by
val acc = new ChecksumAccumulator // sum refference = 0
val csa = new ChecksumAccumulator // sum refference = 0, same

acc.num = 3 // Now acc points to 3, and csa to 0

acc.add(2)
acc.checksum()
