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
  //val john = aPerson.name // class parameter!= field
  val johnSaysHiToDaniel = aPerson.greet("Daniel")
  val johnSaysHi = aPerson.greet()


  def main(args: Array[String]): Unit = {
    val charlesDickins = new Writer("Charles", "Dickins", 1812)
    val charlesDickinsImposter = new Writer("Charles", "Dickins", 2021)
    val novel = new Novel("Great Expectations", 1861, charlesDickins)
    val newEdition = novel.copy(1871)

    println(charlesDickins.fullName)
    println(novel.authorAge())
    println(novel.isWrittenBy(charlesDickinsImposter))  //false
    println(novel.isWrittenBy(charlesDickins))  //true
    println(newEdition.authorAge())

    val counter = new Counter()
    counter.print() //0
    counter.increment().print() //1
    counter.increment() 
    counter.print() //0
  }
}
/**
 * Exercise : Imagine we're creating a backend for a publishing house.
 * Create a Novel and a writer class
 *
 * Write : firstName, Surname, year
 *  - method fullname
 *
 * Novel : name , year of release, author
 *  - author age
 *  - isWrittenBy ( author )
 *  - copy (new year of release ) - new instance of Novel
 *  
 */

class Writer(firstName: String, surName: String,val yearOfBirth: Int) {   // after adding val I can access it as a field
  def fullName: String =
    s"$firstName $surName"

}

class Novel(title: String, yearOfRelease: Int, author: Writer) {
  def authorAge(): Int =
    yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: Writer): Boolean =
    this.author == author

  def copy(newYearOfRelease: Int): Novel =
    new Novel(this.title, newYearOfRelease, this.author)
}

/**
 * Exercise 2 : an immutable counter class
 *    - constructed with an initial count
 *    - increment/decrement - NEW instance of counter
 *    - increment(n)/decrement(n) - NEW instance of counter
 *    - println()
 *    
 * Benefits : 
 *  - well in distributed environments
 *  - easier to read and understand code
 */
// Using not parenthesis for getter like methods ( like accessor ) and using parenthesis for action like methods
class Counter(count: Int = 0) {   //default value of 0
  def increment(): Counter = new Counter(count+1)
  def decrement(): Counter =
    if (count == 0) this
    else new Counter(count-1)   // check if the count becomes 0
  def increment(n: Int): Counter = 
    new Counter(count+n)
    // if (n <= 0) this
    // else increment().increment(n-1)
  def decrement(n: Int): Counter = 
    new Counter(count-n)
    // if (n <= 0) this
    // else decrement().decrement(n-1)
  def print(): Unit = println(s"Current Counter value - $count")
}
