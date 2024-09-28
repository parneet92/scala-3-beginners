package com.rockthejvm.part1basics

object Functions {

  // = indeicates implementation of the function and its always a single expression
  def aFunction(a: String, b: Int): String =
    a + "" + b    //ONE expression

  //function invocation
  val aFunctionInvocation = aFunction("Scala", 9999)

  // Both the below declarations do the same thing
  def aNoArgFunction(): Int = 45
  def aParamterlessFunction: Int = 45

  //functions can be recurssive
  def stringConcatenation(str: String, n: Int): String =
    if(n == 0) ""
    else if(n == 1) "str"
    else str + stringConcatenation(str, n-1)

  /*
    sc("Scala",3) = "Scala" + sc("Scala",2) = "Scala" + "ScalaScala" = "ScalaScalaScala"
    sc("Scala",2) = "Scala" + sc("Scala",1) = "Scala" + "Scala" = "ScalaScala"
    sc("Scala",1) = "Scala"
   */
  val scalax3 = stringConcatenation("Scala", 3)

  //when you need loops use RECURSION

  //"void" functions
  def aVoidFunction(aString: String): Unit =
    println(aString)

  def aComputeDoubleStringWithSideEffect(aString: String): String = {
    aVoidFunction(aString)    //Unit
    aString + aString       //meaningful value
  }//discouraging side effects ( usually advisable to avoid them )

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n+1)
  }

  /**
   * Exercises
   * 1. A greeting function (name,age) => "Hi my name is $name and I am $age years old.
   * 2. Factorial Function n => 1 * 2 * 3 * 4 ... n
   * 3. Fibonacci Function
   *    fib(1) = 1
   *    fib(2) = 1
   *    fib(n) = fib(n-1) + fib(n-2)
   *
   * 4. Tests if a number is prime
   */

  //1
  def greeting(name: String, age: Int): Unit = println("Hi my name is "+name+" and I am "+age+" years old")

  //2
  /*
  factorial(4) = 4 * factorial(3) = 4 * 6 = 24
  factorial(3) = 3 * factorial(2) = 3 * 2 = 6
  factorial(2) = 2 * factorial(1) = 2 * 1 = 2
  factorial(1) = 1
   */
  def factorial(n: Int): Double = {
    if(n<=0) 0
    else if(n==1) 1
    else n * factorial(n-1)
  }

  //3
  /*
  fib(5) = fib(4) + fib(3) = 3 + 2 = 5
  fib(4) = fib(3) + fib(2) = 2 + 1 = 3
  fib(3) = fib(2) + fib(1) = 1 + 1 = 2
  fib(2) = 1
  fib(1) = 1
   */
  def fib(n: Int): Int = {
    if(n <= 2) 1 else fib(n-1) + fib(n-2)
  }

  //4
  /*
  isPrime(9) = sqrt(9) = 3
   */
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if(t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(n/2)
  }


  def main(args: Array[String]): Unit = {
    greeting("parnit", 32)
    println(factorial(6))
    println(fib(6))
    println(isPrime(37))
  }
}
