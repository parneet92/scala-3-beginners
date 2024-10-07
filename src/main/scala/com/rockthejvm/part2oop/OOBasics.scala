package com.rockthejvm.part2oop

object OOBasics {

  // the class takes argument similar to functions
  // this means this is Constructor parameters
  // In other language we have concept of field and method attached to instance of class Person

  class Person(name: String, age: Int) {  // constructor signature
    //fields
    val allCaps = name.toUpperCase()

    //methods
    def greet(name: String): Unit =
      s"${this.name} says: Hi $name"

    // signature differs
    // OVERLOADING
    def greet(): String =
      s"Hi everyone my name is $name"

    // aux constructor ( In scala we don't use them as much because we could use default argument )
    def this(name: String) =
      this(name, 0)

    def this() =
      this("Jane Does")
  }

  val aPerson: Person = new Person("John", 26)
  val john = aPerson.name // class parameter!= field
  val johnSaysHiToDaniel = aPerson.greet("Daniel")
  val johnSaysHi = aPerson.greet()


  def main(args: Array[String]): Unit = {

  }
}
