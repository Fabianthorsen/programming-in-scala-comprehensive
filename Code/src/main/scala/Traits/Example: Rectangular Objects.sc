class Point(val x: Int, val y: Int)

trait Rectangular {
  def topLeft: Point
  def bottomRight: Point
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
  // many more geometric methods
}

abstract class Component extends Rectangular {
  // other methods
}

class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular {
  // other methods
}


// can now create a rectangle and call geometric methods such as width and left
val rect = new Rectangle(new Point(1,1), new Point(10,10))
rect.left
rect.right
rect.width