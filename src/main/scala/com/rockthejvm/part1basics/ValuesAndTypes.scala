package com.rockthejvm.part1basics

object ValuesAndTypes {

  //values
  val meaningOfLife: Int = 42     // value cannot be reassigned, assigning is not allowed , constant in other language

  //type inference
  val anInteger = 67      // :Int is optional ( type inference )

  //common types
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = 78     //4 bytes
  val aShort: Short = 32    //2 bytes
  val aLong: Long = 7663L     //8 bytes
  val aFloat: Float = 7.89f   //4 bytes
  val aDouble: Double = 3.14    //8 bytes

  //String
  val aString: String = "Scala"

  // It will make the object runnable
  def main(args: Array[String]): Unit = {

  }

}
