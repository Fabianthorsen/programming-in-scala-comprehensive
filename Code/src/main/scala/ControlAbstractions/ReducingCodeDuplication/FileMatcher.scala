package ControlAbstractions.ReducingCodeDuplication

import java.io.File

/* Benefits of HOFs
* - Enable to create control abstractions to allow to reduce code duplication
* - Condense and simplify code
* */

object FileMatcher {
  // Gets a list of files in current directory
  private def filesHere = new java.io.File(".").listFiles

  // Define a function that can do all three
  // The similarity is that all three have a query and a method they apply with the query
  // Lets pass the method into the parameters of the method
  //  def filesMatching(query: String, matcher: (String, String) => Boolean): Array[File] =
  //    for (file <- filesHere if matcher(file.getName, query))
  //      yield file
  // Can rewrite this further as well
  def filesMatching(matcher: String => Boolean): Array[File] =
    for (file <- filesHere if matcher(file.getName))
      yield file

  // Yield files only with a queried ending
//  def filesEnding(query: String): Array[File] =
//    for (file <- filesHere if file.getName.endsWith(query6))
//      yield file
  // Can now simplify above expression
  // (fileName: String, query: String) => fileName.endsWith(query) is what happens
  def filesEnding(query: String): Array[File] =
    filesMatching(_.endsWith(query))

  // Add new method to let people search based on any part of the file name
  // This now contains a lot of duplicate code from above
//  def filesContaining(query: String): Array[File] =
//    for (file <- filesHere if file.getName.contains(query))
//      yield file
  def filesContaining(query: String): Array[File] =
    filesMatching(_.contains(query))

  // Allow power users to search via regex
  // Again, duplicate code from above
//  def filesRegex(query: String): Array[File] =
//    for (file <- filesHere if file.getName.matches(query))
//      yield file
  def filesRegex(query: String): Array[File] =
    filesMatching(_.matches(query))

  def main(args: Array[String]): Unit = {
    println(filesMatching(_.endsWith(".scala")).mkString("\n"))
    println(filesEnding(".scala").mkString("\n")) // Equivalent to calling the above
  }
}


