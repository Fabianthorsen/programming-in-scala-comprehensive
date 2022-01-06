package TypeParameterization

// From video: https://www.youtube.com/watch?v=aUmj7jnXet4&ab_channel=RocktheJVM
// Addition to the other subjects in this chapter

object VariancePositions {
  class Animal
  class Dog extends Animal
  class Cat extends Animal
  class Crocodile extends Animal

  class MyList[+T]

  // if Dogs are Animals, then is a MyList[Dog] also a MyList[Animal]?
  // ^The variance question.

  // Different answers to this questions:
  // 1 - yes => generic type is COVARIANT +T
  val anAnimal: Animal = new Dog
  val animals: MyList[Animal] = new MyList[Dog]

  // 2 - no => generic type is INVARIANT (absence of +/- in type)

  // 3 - HELL-NO! => generic type is CONTRAVARIANT -T
  class Vet[-T]
  val lassiesVet: Vet[Dog] = new Vet[Animal] // Backwards subtype relationship
  // A vet can heal any animal, but for lassie the vet is a vet for a dog, but
  // could possibly be a vet for ANY animal as well.

  /*
  abstract class MyList2[+T] {
    def head: T
    def tail: MyList2[T]
    def add(elem: T): MyList2[T] // Cannot be elem T because T is covariant, while list is Contravariant
  }
  */

  // Types of val fields
  /*
  // types of val fields are in COVARIANT position
  class Vet2[-T](val favouriteAnimal: T)

  val garfield = new Cat
  val theVet: Vet2[Animal] = new Vet2[Animal](garfield)
  val lassiesVet2: Vet2[Dog] = theVet
  val lassie: Dog = lassiesVet2.favouriteAnimal // What type? -> Cat, so a type conflict
  */

  // Types of var fields are also in COVARIANT position
  // class Vet3[-T](var favouriteAnimal: T)

  // Types of var fields are in CONTRAVARIANT position
  /*
  class MutableOption[+T](var contents: T)
  val maybeAnimal: MutableOption[Animal] = new MutableOption[Dog](new Dog) // Must guarantee that contents is a dog
  maybeAnimal.contents = new Cat // since var we can re-assign, TYPE CONFLICT
  */

  // type of method arguments in CONTRAVARIANT POSITION
  /*
  class MyList2[+T] {
    def add(elem: T): MyList2[T] = ???
  }
  val animals2: MyList2[Animal] = new MyList2[Cat]
  val moreAnimals2 = animals2.add(new Dog) // Is this legal? -> NO, since animal is dog, and it is MyList[Cat]
  */

  class Vet3[-T]{
    def heal(animal: T): Boolean = true
  }

  val lassiesVet3: Vet3[Dog] = new Vet3[Animal]
  lassiesVet3.heal(new Dog)
  // lassiesVet3.heal(new Cat) // Heal takes an argument of same type as Vet3 class
  // This is a valid error

  // Method return types are in COVARIANT position
  /*
  abstract class Vet4[-T] {
    def rescueAnimal(): T
  }

  val vet4: Vet4[Animal] = new Vet4[Animal]{
    override def rescueAnimal(): Animal = new Cat
  }
  val lassiesVet4: Vet4[Dog] = vet4
  val rescuedDog: Dog = lassiesVet4.rescueAnimal() // Will return a Cat type, which is a type conflict
  // But we SHOULD actually return a dog, since lassie is a Vet4[Dog]
  */

  class MyListC[+T]{
    // If we add a Cat to a list of Dog, we get a list of Animal
    // Lower bound of T
    // S is a supertype of T
    def ads[S >: T](elem: S): MyList[S] = new MyList[S]
  }

  class VetC[-T]{
    // Upper bound of T
    def rescueAnimal[S <: T](): S = ???
  }

  val lassiesVetC: VetC[Dog] = new VetC[Animal]
  val rescueDogC: Dog = lassiesVetC.rescueAnimal() // Compiler will then infer -> rescueAnimal[Dog]
}
