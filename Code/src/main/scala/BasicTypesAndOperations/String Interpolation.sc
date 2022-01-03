// allows for embedding expressions within string literals
val name = "reader"
println(s"Hello, $name")

println(s"The answer is ${6 * 7}")

// Two other string interpolators by default: raw and f
// raw behaves like s, but does not recognize escape sequences
println(raw"No\\\\\escape")

// f string interpolator allows for printf-style formatting
println(f"${math.Pi}%.5f") // Pi with 5 decimals of precision
