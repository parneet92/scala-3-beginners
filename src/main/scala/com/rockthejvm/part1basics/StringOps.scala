package com.rockthejvm.part1basics

object StringOps {

  val aString = "Hello I am learning Scala ... "

  // string functions
  val secondChar = aString.charAt(1)
  val firstWord = aString.substring(0, 5) // "Hello"
  val words = aString.split(" ")  // Array("Hello,","T","am","learning","Scala")
  val startsWithHello = aString.startsWith("Hello")   // true
  val allDashes = aString.replace(' ', '-')
  val allUppercase = aString.toUpperCase()
  val allLowercase = aString.toLowerCase()
  val nChars = aString.length

  // other functions
  val reversed = aString.reverse
  val aBunchOfChars = aString.take(10)

  //parse to Numeric types
  val numberAsString = "2"
  val number = numberAsString.toInt

  //interpolation
  val name = "Alice"
  val age = 12
  val greeting = "Hello, I'm " + name + " and I am " + age + " years old. "
  val greeting_v2 = s"Hello, I'm $name and I am $age years old"
  val greeting_v3 = s"Hello, I'm $name and I will be turning ${age+1} years old" // You can have any scala expression inside the curly braces
 
  //f-interpolation ( you can do printf like formats) ( more powerful version of s interpolator )
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute."
  
  // raw-interpolation
  val escapes = raw"This is a \n newline" //now the \n treated as literal value instead of new line
  
  
  def main(args: Array[String]): Unit = {

  }

}
