// An immutable class will always return the same element, no matter what
val cs = List('a', 'b', 'c')
cs.head // will ALWAYS return 'a'

// For mutable object, the result of a method call of field access may depend on the operation done previously
// on the object
class BankAccount {
  private var bal: Int = 0

  def balance: Int = bal

  def deposit(amount: Int) =
    require(amount > 0)
    bal += amount

  def withdraw(amount: Int): Boolean =
    if (amount > bal) false
    else {
      bal -= amount
      true
    }
}

val account = new BankAccount
account deposit 100
account withdraw 80
account withdraw 80 // returns different result
// than the withdraw call above
// Bank accounts have a mutable state
// Might not always be direct mutability from var
// since a method can call mutable variables
// also, a class can contain variables and be
// 100% functional.

