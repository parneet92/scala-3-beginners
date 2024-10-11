package com.rockthejvm.part2oop

object PreventingInheritance {

  class Person(name: String){
    final def enjoyLife(): Int = 42
  }

  class Adult(name: String) extends Person(name){
    // cannot override final method
    //override def enjoyLife() = 999    // this override is not legal as its defined final
  }

  final class Animal
  //class Cat extends Animal    // cannot be inherited

  //sealing a type hierarchy = inheritance only permitted inside this file
  sealed class Guitar(nStrings: Int)
  class ElectricGuitar(nStrings: Int) extends Guitar(nStrings)
  class AcousticGuitar extends Guitar(6)

  //no modifier = "not encouraging" inheritance
  // not mandatory, good practice
  open class ExtensibleGuitar(nStrings: Int)    //OPEN = SPECIFICALLY MARKED FOR INHERITANCE

  def main(args: Array[String]): Unit = {

  }

}
