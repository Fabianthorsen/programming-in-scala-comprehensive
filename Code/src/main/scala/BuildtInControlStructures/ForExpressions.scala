package BuildtInControlStructures

object ForExpressions extends App{
  // Also known as the "Swiss army knife of iteration" in scala

  // Iterating through a collection
  // Do some IO to get files in the "." path
  val filesHere = (new java.io.File(".")).listFiles

  // This is called a generator
  for (file <- filesHere)
    println(file)

  // For expression on a Range type
  for (i <- 1 to 4)
    println(s"Iteration $i")

  // Without including the upper bound
  for (i <- 1 until 4)
    println(s"Iteration $i")

  // This style of iteration isnt very common in scala:
  for (i <- 0 until filesHere.length)
    println(filesHere(i))

  // Filtering
  for (file <- filesHere)
    if (file.getName.endsWith(".scala"))
      println(file)

  // more common syntax using guards
  for (
    file <- filesHere
    if file.isFile
    if file.getName.endsWith(".sc")
  ) println(file)

  // Nested iteration
  // Helper function to read contents of file
  def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toList
  // Homemade Grep tool
  def grep(pattern: String): Unit =
    for {
      file <- filesHere
      if file.getName.endsWith(".sc")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(pattern)
    } println(s"$file: $trimmed")

  grep(".*gcd.*")

  // Producing a new collection
  def scalaFiles = // scalaFiles is now Array[File]
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
    } yield file

  // for { clause } yield body is the syntax to use yield
}
