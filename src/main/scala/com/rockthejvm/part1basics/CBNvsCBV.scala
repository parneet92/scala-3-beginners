package com.rockthejvm.part1basics

object CBNvsCBV {

  // CBV = call by value = arguments are evaluated before function invocation
  def aFunction(arg: Int) = arg + 1
  val aComputation = aFunction(76 + 6)    // the value 76 + 876 is computed first before invoking the aFunction, arg has value of 82

  // CBN = call by name = arguments are passed literally as expression = arguments are passed LITERALLY
  def aByNameFunction(arg: => Int) = arg + 1
  val anotherComputation = aByNameFunction(23 + 67) // this expression is passed literally to aByNameFunction where arg has value of "23+67"

  def printTwiceByValue(x: Long): Unit = {
    println("By value: "+x)
    println("By value: "+x)
  }

  /*
    - delayed evaluation of the argument
    - argument is evaluated every time it is used
   */
  def printTwiceByName(x: => Long): Unit = {
    println("By name: " + x)
    println("By name: " + x)
  }

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)


  def main(args: Array[String]): Unit = {
    printTwiceByValue(System.nanoTime())
    printTwiceByName(System.nanoTime())
    printFirst(42, infinite())
  }
}

/*
Takeaways
Call by Value - arguments are evaluated before the call
Call By Name (=>) - expression is passed literally and is evaluated every time the function is invoked
 */