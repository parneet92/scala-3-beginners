package com.rockthejvm.part2oop

object Objects {

  // objects are essentially singleton pattern in one line
  // objects can have body like class definition
  object MySingleton {      // TYPE + only instance of this type
    val aField = 45
    def aMethod(x: Int) = x + 1
  }

  val singleton = MySingleton
  val anotherSingleton = MySingleton
  val isSameSingleton = singleton == anotherSingleton

  // objects can have filed and methods
  val theSingletonField = MySingleton.aField
  val theSingletonMethodCall = MySingleton.aMethod(7)

  class Person(name: String){
    def sayHi(): String = s"Hi, My name is $name"
  }

  // companions = object + class with the same name in the same file
  object Person{    // companion object
    // can access each other's private fields and methods
    val N_EYES = 2
    def canFly(): Boolean = false
  }

  // methods and fields in classes are used for instance dependent functionality
  val mary = new Person("Mary")
  val maryV2 = new Person("Mary")
  val marysGreeting = mary.sayHi()

  // methods and fields in objects are used for instance independent functionality - "static"
  val humansCanFly = Person.canFly()
  val nEyesHuman = Person.N_EYES

  //equality
  // 1 - equality of reference ( if they point to exact same reference in memory
  val sameMary = mary eq maryV2   //false, different instances ( usually defined as ==
  val sameSingleton = MySingleton eq MySingleton    //true
  // 2 - equality of "sameness" ( its upto programmers what sameness means) ( in Java defined as .equals )
  val sameMaryV2 = mary equals maryV2 // false
  val sameMaryV3 = mary == maryV2 // false (same as equals) ( IN scala we use == )
  val sameSingletonV2 = MySingleton == MySingleton  // true

  // objects can extend classes ( abstract classes, traits)
  object BigFoot extends Person("Big Foot")

  // Scala Application = object + def main(args: Array[String]): Unit
  /*
  In java we have similar start of application
  public class Objects {
    public static void main(String[] args){....}
  }
   */
  def main(args: Array[String]): Unit = {
    println(isSameSingleton)
  }

}
