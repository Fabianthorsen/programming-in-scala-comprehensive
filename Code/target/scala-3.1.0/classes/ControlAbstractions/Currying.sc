// A curried function is applied to multiple argument lists, instead of just one
def plainOldSum(x: Int, y: Int): Int = x + y
plainOldSum(1,2)

def curriedSum(x: Int)(y: Int): Int = x + y
curriedSum(1)(2)

// When curriedSum is invoked, get two function invocations back-to-back
def first(x: Int) = (y: Int) => x + y
val second = first(1)
second(2)
// Basically creates a function like Int => Int => Int

// Can use placeholder syntax with curried functions
val onePlus = curriedSum(1)_
onePlus(2) // 3