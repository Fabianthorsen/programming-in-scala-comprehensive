// Compare using equivalent == or not equivalent !=
1 == 2
1 != 2
2 == 2

// can be applied to all objects
List(1,2,3) == List(1,2,3)
List(1,2,3) == List(4,5,6)

// Can compare different types
1 == 1.0
null == List(1,2,3)

// As long as equals method is written to be based on the content
// the comparison will yield true for different objects
("he" + "llo") == "hello"

/* How scala == is different to Java ==
* On primitive types, Java compares value equality, as in Scala
* On reference types, Java compares REFERENCE EQUALITY, which
* means the two variables point to the same object on the JVM heap.
* Scala provides a facility for comparing reference equality, as well,
* under the name eq. However, eq. and its opposite, ne, only apply to
* objects that directly map to Java objects.
* /
