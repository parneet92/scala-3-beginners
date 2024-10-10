package com.rockthejvm.part2oop

object Inheritance {

  class Animal{
    val creatureType = "wild"
    def eat(): Unit = println("nomnomnom")
  }

  class Cat extends Animal {
    def crunch() = {
      eat()
      println("crunch, crunch")
    }
  }

  val cat = new Cat

  class Person(val name: String, age: Int) {
    def this(name: String) = this(name, 0)    // using secondary constructor not really useful, especially you have to tell specify super constructor when extending during class declaration

  }

  class Adult(name: String, age: Int, iCard: String) extends Person(name)   // must specify super-constructor

  // overriding
  class Dog extends Animal {
    override val creatureType: String = "domestic"
    override def eat(): Unit = println("mmm, I like this bone!!")

    // popular overridable method
    override def toString: String = "a dog"
  }

  val dog = new Dog

  // subtype polymorphism
  val Dog: Animal = new Dog
  dog.eat()     // the most specific method will be called at the runtime

  // overloading vs overriding

  class Crocodile extends Animal {
    override val creatureType: String = "very wild"
    override def eat(): Unit = println("I can eat anything , I am a croc!")

    //overloading: mutiple different methods with same name, different signatures
    //different signature =
    //   different argument list (different number of args + different arg types)
    //    + different return type (optional)
    def eat(animal: Animal): Unit = println("I am eating this poor fells")

  }

  def main(args: Array[String]): Unit = {
    cat.eat()
    cat.crunch()

    println(dog)    // println(dog.toString)
  }
}
