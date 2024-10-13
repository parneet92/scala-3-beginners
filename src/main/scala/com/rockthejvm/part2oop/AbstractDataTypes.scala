package com.rockthejvm.part2oop

object AbstractDataTypes {

  abstract class Animal {
    val creatureType: String    //abstract
    def eat(): Unit
    //non abstract fields/methods allowed
    def preferredMeal: String = "anything"    //accessor method
  }

  //abstract classes cannot be instantiated
  //val anAnimal = new Animal   // illegal

  // non-abstract classes must implement the abstract fields/methods
  class Dog extends Animal{
    override val creatureType = "Domestic"
    override def eat(): Unit = println("crunching this bone")
    // override is legal for everything
    // changed method to val while overriding ( only allowed when method has no args/parenthesis )
    override val preferredMeal: String = "bone"   // overriding accessor method with a field
  }

  val aDog: Animal = new Dog

  //traits ( it's a data type that describes behaviour ) ( In java , analogy is Interface )
  trait Carnivore{  // Scala 3 - traits can have constructor args
    def eat(animal: Animal): Unit
  }

  class TRex extends Carnivore{
    override def eat(animal: Animal): Unit = println("I am a T rex, I eat animals")
  }

  // practical difference between abstract and traits
  // one class inheritance
  // multiple traits inheriatance
  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded{
    override val creatureType: String = "croc"

    override def eat(animal: Animal): Unit = println(" I am a croc eating animal")

    override def eat(): Unit = println("I am a croc")
  }

  /*
   philosophical difference between abstract and traits
    - abstract classes are things
    - traits are behaviours
   */

  /*
    Any
      - AnyRef (equivalent to java.lang.Object in Java)
          All classes we write extends AnyRef
            scala.Null ( the NUll reference )
      - AnyVal
          Int, Boolean, Char,.... ( primmitive datatypes extending AnyVal )

        scala.Nothing
   */
  val aNonExistentAnimal: Animal = null
  val anInt: Int = throw new NullPointerException()   // this doesn't retuyrn any value ( it return scala.Nothing )
  def main(args: Array[String]): Unit = {

  }

}

