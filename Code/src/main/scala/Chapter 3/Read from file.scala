object ReadFromFile{
  def main(args: Array[String]): Unit = {
    // Import needed for reading file
    import scala.io.Source
    // Helper-function to get the length of the "length-number", i.e. if length is 77, width is 2
    def widthOfLength(s: String): Int = s.length.toString.length
    if (args.length > 0) {
      // Read from the file that is given as the first argument
      val lines = Source.fromFile(args(0)).getLines().toList
      // Retrieve the longest line by checking each lines length
      val longestLine = lines.reduceLeft((a, b) => if (a.length > b.length) a else b)
      // Get max width of length-numbers
      val maxWidth = widthOfLength(longestLine)
      // Iterate through the lines
      for (line <- lines) {
        // Determine how many spaces needed for paddng
        val numSpaces = maxWidth - widthOfLength(line)
        // Create a padding object
        val padding = " " * numSpaces
        // Create the final string for the line
        println(s"$padding ${line.length} | $line")
      }
    }
  }
}

