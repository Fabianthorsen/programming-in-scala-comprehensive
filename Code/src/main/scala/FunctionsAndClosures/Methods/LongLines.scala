package FunctionsAndClosures.Methods
import scala.io.Source

object LongLines {
  def processFile(filename: String, width: Int): Unit =
    // Local function instead of private def ...
    // This helps to not pollute namespace
    def processLine(line: String): Unit = {
      if (line.length > width)
        println(s"$filename: ${line.trim}")
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(line)
}
