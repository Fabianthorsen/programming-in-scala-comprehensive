// Behaves as in other languages
def gcdLoop(x: Long, y: Long): Long =
  var a = x
  var b = y
  while (a != 0) {
    val temp = a
    a = b % a
    b = temp
  }
  b

gcdLoop(12,8)

// Called loop because it does not return a
// value, and thus is not an expression
// Usually do not use loops, but recursion
@annotation.tailrec
def gcd(a: Long, b: Long): Long =
  if (b == 0) a
  else gcd(b, a % b)

gcd(12,8)
