/* Java way
* boolean isEqual(int x, int y) {
*   return x == y;
* }
* System.out.println(isEqual(421, 421)
*
* Java Again, but this is false
* boolean isEqual(Integer x, Integer y) {
*   return x == y;
* }
* System.out.println(421, 421)
* False due to 421 gets boxed twice, and are now
* two different objects
* */

// Same experiment in scala
def isEqual(x: Int, y: Int): Boolean = x == y
isEqual(421, 421)

def isEqual(x: Any, y: Any): Boolean = x == y
isEqual(421, 421) // True again, unlike java

// Scala will never fall into Java's trap concerning
// string comparisons
val x = "abcd".substring(2)
val y = "abcd".substring(2)
x == y // True
x eq y // False since this checks for reference equality
x ne y


