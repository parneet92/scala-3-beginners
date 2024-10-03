package com.rockthejvm.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion {

  // repetition = recursion in this world

  /*
    sumUntil(10) = 10 + sumUntil(9)
    sumUntil(9) = 9 + sumUntil(8)
    ...
    sumUntil(0) = 0
   */
  def sumUntil(n: Int) : Int = {
    if(n <= 0) 0 else n + sumUntil(n-1)   // here the last operation is addition not the recursive call
  }


  def sumUntil_v2(n: Int): Int = {
    /*
      sut(10,0) =
      sut(9, 10) =
      sut(8, 9 + 10) =
      sut(7, 8 + 9 + 10) =
      ...
      sut(0, 1+2+3+...+10) = 1+2+3+...+10
     */
    @tailrec  //it will validate whether the recursive call happens last in the code path
    def sumUntilTailRec(x: Int, accumulator: Int): Int =
      if(x <= 0) accumulator
      else sumUntilTailRec(x-1, x + accumulator)  // TAIL recursion = recursive call occurs last in its code path
      // when recursive call is last on its code path , scala compiler optimise the recursive call to resuse the stack frame
      //no further stack frames necessary = no more risk of Stack overflow error
    sumUntilTailRec(n, 0)
  }

  // how to think to write tail recursive function ( written by me )
  /*
  snb(2,5) = 5 + snb(2,4) = 5 + 9 = 14
  snb(2,4) = 4 + snb(2,3) = 4 + 5 = 9
  snb(2,3) = 3 + snb(2,2) = 3 + 2 = 5
  snb(2,2) = 2

  def sumNumbersBetween(a: Int, b: Int): Int = {
    if (a >= b) a
    else b + sumNumbersBetween(a, b-1)
  }
  */

  /*
  snb(2,5) = 2 + snb(3,5) = 4+5+3+2
  snb(3,5) = 3 + snb (4,5) = 4+ 5+3
  snb(4,5) = 4 + snb(5,5) = 4 + 5
  snb(5,5) = 5 + snb(6,5) = 5
  snb(6,5) = 0
   */
  def sumNumbersBetween(a: Int, b: Int): Int = {
    if ( a > b ) 0
    else a + sumNumbersBetween(a+1, b)
  }

  def sumNumbersBetween_v2(a: Int, b: Int) = {
    @tailrec
    def sumTailRec(currentNumber: Int, accumulator: Int): Int = {
      if(currentNumber > b) accumulator
      else sumTailRec(currentNumber+1, currentNumber + accumulator)
    }
    sumTailRec(a,0)
  }

  /**
   * Exercise
   *  1. Concatenate string n times
   *  2. Fibonacci function , tail recursive
   *  3. Is isPrime function tail recursive or not ?
   */

    //1

    def concatString(str: String, n: Int): String = {
      @tailrec
      def concatTailRec(x: Int, accumulator: String): String = {
        if(x <= 0) accumulator
        else concatTailRec(x-1, accumulator+str)
      }
      concatTailRec(n,"")
    }

  //2
  /*
  fib(5) = fib(4) + fib(3)
  fib(4) = fib(3) + fib(2)
  fib(3) = fib(2) + fib(1)

  frt(2,1,1) = 
  frt(3,2,1) = 
  frt(4,3,2) = 
  frt(5,5,3) = 5

   */
  def fib(n: Int): Int = {
    @tailrec
    def fibRecTail(counter: Int, current: Int, previous: Int): Int = {
      if (counter >= n) current
      else fibRecTail( counter+1, current + previous, current )
    }
    if (n <= 2) 1
    else fibRecTail(2, 1,1)
  }

  //3 - yes
  //this func is already tail recursive when I look at the sign in Intellij ( how's that possible ? )
  // It seems like last operation is && 
  // Answer : However && operation is short circuiting, meaning if the first expression is false then isPrimeUntil wouldn't get called
  // and if the first expression is true then second expression is the last in the call stack
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean = {
      if(t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(n/2)
  }

  def main(args: Array[String]): Unit = {
    // println(sumUntil(20000)) => stackOverflow ( we relying on call stack to repeat )
    println(sumUntil_v2(20000))
    println(concatString("Hello",1))
    println(fib(5))
  }
}
