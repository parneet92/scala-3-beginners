package com.rockthejvm.part2oop

object AnonymousClasses {

  abstract class Animal {
    def eat(): Unit
  }

  // classes used for just onr instance are boilerplate-y
  class SomeAnimal extends Animal {
    override def eat(): Unit = println("I am a weird animal")
  }

  // if the someanimal data type is very short lives, only instantiated for the use of once or twice
  // so the whole definition of class is redundant
  // so in Scala we instantiate them on the spot
  val someAnimal = new SomeAnimal
  val someAnimal_v2 = new Animal { // anonymous class
    override def eat(): Unit = println(" I am very weird animal")
  }

  /*
  what compiler does is create such a class for anonymous class
  class AnonymousClass.AnonClass$1 extends Animal {
    override def eat(): Unit = println(" I am very weird animal")
  }
  
  val someAnimal_v2 = new AnonymousClass.AnonClass$1
   */
  
  // you can use anonymous class for abstract, trait and non abstract classes
  
  class Person(name: String) {
    def sayHi(): Unit = println(s"Hi my name is $name")
  }
  
  val jim = new Person("Jim") {
    override def sayHi(): Unit = println("MY NAME IS JIM")
  }
  def main(args: Array[String]): Unit = {

  }

}
