// All basic type can be written with literals
// A literal is a way to write a constant value directly in code

// Integer literals
val hex = 0x5
val hex2 = 0x00FF
val magic = 0xcafebabe

// If number begins with a non-zero digit and is undecorated
// it is a decimal (base10)
val dec1 = 31
val dec2 = 255
val dec3 = 20

// If a number ends with an L or l, it is a Long; otherwise it is an Int
val prog = 0XCAFEBABEL
val tower = 35L
val of = 31L

// If int literal is assigned to var of type Short or byte, it is
// treated as if it were a Short or Byte so long the literal value
// is within the valid range for the type
val little: Short = 367
val littler: Byte = 38

// Floating pooint literals
val big = 1.2345
val bigger = 1.2345e1
val biggerStill = 123E45

val little = 1.2345F // Float
val littleBigger = 3e5f // also float
val anotherDouble = 3e5 // Double
val yetAnother = 3e5D // also Double

// Character literals
val a = 'A'
val d = '\u0041'
val f = '\u0044'

// Special escape sequences
val backslash = '\\'

/* Special literal escape sequences
* \n - line feed (\u000A)
* \b - backspace (\u0008)
* \t - tab (\u0009)
* \f - form feed (\u000C)
* \r - carriage return (\u000D)
* \" - double quote (\u0022)
* \' - single quote (\u0027)
* \\ - backslash (\u005C)
*/

// String literals
val hello = "hello"
val escapes = "\\\"\'"

// Multiline strings
println(
  """
    |Welcome to Ultamix 3000.
    |Type "HELP" for help.
    |""".stripMargin)

// Symbol literals are not longer supported

// Boolean literals
val bool = true
val fool = false