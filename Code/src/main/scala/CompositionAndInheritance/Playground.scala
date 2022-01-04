package CompositionAndInheritance
import Element.elem

object Playground {
  object Spiral {
    val space: Element = elem(" ")
    val corner: Element = elem("+")

    def spiral(nEdges: Int, direction: Int): Element =
      if (nEdges == 1) elem("+")
      else {
        val sp = spiral(nEdges - 1, (direction + 3) % 4)
        def verticalBar = elem('|', 1, sp.height)
        def horizontalBar = elem('-', 1, sp.height)
        if (direction == 0) (corner beside horizontalBar) above (sp beside space)
        else if (direction == 1) (sp above space) beside (corner above verticalBar)
        else if (direction == 2) (space beside sp) above (horizontalBar beside corner)
        else (verticalBar above corner) beside (space above sp)
      }
  }

  def main(args: Array[String]): Unit = {
    import Spiral.spiral
//  new Element // Will not work as the class is abstract
    // val e1 = new ArrayElement(Array("Hello", "World"))
    // println(e1.width) // length of "Hello"
    // Subtyping means that a value of the subclass can be used wherever a value of the super class is required

    // val ae: ArrayElement = new LineElement("hello")
    // val e2: Element = ae
    // val e3: Element = new UniformElement('x', 3, 2)
//    println(e1) // ArrayElement
//    println(e2) // LineElement
//    println(e3) // UniformElement

    // Using the factory pattern to create new instance
    val nSides = 6
    println(spiral(nSides, 1))
  }
}
