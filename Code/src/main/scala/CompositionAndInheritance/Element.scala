package CompositionAndInheritance

// Element represents layout items
// content refers to the contents of a layout Element
// that can be represented as an array of strings, where each string represents a line
// A method is abstract if it has no implementation i.e. =-sign or body
import Element.elem
abstract class Element {
  def contents: Array[String]
  // Defining parameterless methods
  // Use these when there are NO PARAMETERS AND the method access mutable state ONLY by reading fields of the
  // containing object (must not change mutable state)
  def height: Int = contents.length // Number of lines in the contents
  def width: Int = contents(0).length
    
  // Implementing above, beside and toString
  def above(that: Element): Element =
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
    
  def beside(that: Element): Element =
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for ((line1, line2) <- this1.contents zip that1.contents)
        yield line1 + line2
    )
    
  def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }
    
  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }
    
  override def toString: String = contents mkString "\n"
}

// Extends to inherit all NON-PRIVATE members from element
// with val keyword contents is now a parametric field
// Shorthand to both define a parameter and field at the same time
private class ArrayElement(val contents: Array[String]) extends Element

// Invoking superclass constructors
// extends ArrayElement(Array(s)) would invoke the superclass constructor
// By extending Element instead of ArrayElement it now has a composition relationship with
// Array instead of an inheritance relationship with ArrayElement
private class LineElement(s: String) extends Element {
  val contents: Array[String] = Array(s)
  override def width: Int = s.length
  override def height = 1
}

// Polymorphism and dynamic binding
// This class will have a given height and width
private class UniformElement(
  ch: Char,
  override val width: Int,
  override val height: Int
) extends Element {
  private val line = ch.toString * width
  def contents: Array[String] = Array.fill(height)(line)
}

// Define a factory object for Element
// This will make creating new 
object Element {
  def elem(contents: Array[String]): Element = new ArrayElement(contents)
  def elem(chr: Char, width: Int, height: Int): Element = new UniformElement(chr, width, height)
  def elem(line: String): Element = new LineElement(line)
}