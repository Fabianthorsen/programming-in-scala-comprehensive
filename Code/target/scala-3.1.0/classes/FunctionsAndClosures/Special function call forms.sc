// Repeated parameters
def echo(args: String*): Unit =
  for (arg <- args) println(arg)

echo()
echo("one")
echo("hello", "world") // args inside are Array[String]

val arr = Array("What's", "up", "doc?")
echo(arr) // Does not work

// need to unpack the array as individual arguments
echo(arr: _*)

// Named arguments
def speed(distance: Float, time: Float): Float =
  distance / time

speed(100, 10)
speed(time=10, distance=100) // Different order, same parameters

// Default parameter values
def printTime(out: java.io.PrintStream = Console.out): Unit =
  out.println(s"Time = ${System.currentTimeMillis}")

printTime() // Is called with Console.out as parameter
printTime(out=Console.err)