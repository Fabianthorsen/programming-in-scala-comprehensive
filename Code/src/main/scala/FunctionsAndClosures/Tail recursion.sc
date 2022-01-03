import scala.annotation.tailrec
// An example of a tailrecursive approximation
/*
def approximate(guess: Double): Double =
  if (isGoodEnough(guess)) guess
  else approximate(improve(guess))
*/

// A while loop implementation of same problem
/*
def approxemateLoop(initialGuess: Double): Double =
  var guess = initialGuess
  while(!isGoodEnough(guess))
    guess = improve(guess)
  guess
*/

// The two implementations are exactly equally efficient

// Tracing tail-recursive functions
def boom(x: Int): Int =
  if (x == 0) throw new Exception("Boom")
  else boom(x - 1) + 1 // This is not tail recursive
  // since boom(x - 1) isn't solely the last thing to happen
  //

boom(3) // 4 stack-frames

@tailrec
def bang(x: Int): Int =
  if (x == 0) throw new Exception("Bang")
  else bang(x - 1) // This is now tail recursive

bang(5) // Only a single stack-frame

// Limits of tail-recursion
// JVM makes implementing more advanced forms of tail recursion more difficult
// If recursion is indirect, no optimization is possible
def isEven(x: Int): Boolean =
  if (x == 0) true else isOdd(x - 1)

def isOdd(x: Int): Boolean =
  if (x == 0) false else isEven(x - 1)
