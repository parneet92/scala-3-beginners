package com.rockthejvm.part2oop

/*
Exceptions are specific instances on the JVM ( for every JVM language ) that can crash your application
 */
object Exceptions {

  val aString: String = null
  // aString.length crashes with Null Pointer Exception

  //1. Throwing an exception
  //val aWeirdValue: Int = throw new NullPointerException   // return Nothing ( Nothing can be used for any type )

  //type Throwable
  //  Error, e.g. Stack Overflow Errors, Out Of Memory Error ( specific error condition on JVM )
  //  Exception, e.g. NullPointerException, NSEException,..... (means an error in your program logic)

  def getInt(withExceptions: Boolean): Int =
    if(withExceptions) throw new RuntimeException("No Int for you")
    else 43

  // If there are multiple return types in try and all the case block in catch block
  // then compiler will infer lowest common ancestor
  // the exception will be matched as per the order.
  val potentialFail = try {
    // code that might fail
    getInt(true)  //Int
  } catch {
    // most specific exceptions first
    case e: RuntimeException => "54"    //String
    case e: NullPointerException => 35    // Int
    // ...
  } finally {
    // executed no matter what
    // close resources
    // Unit here
  }

  // custom exceptions
  class MyException extends RuntimeException {
    //fields or methods
    override def getMessage: String = "MY Exception"
  }

  val myException = new MyException()

  /**
   * Exercises :
   * 1. Crash with SOError
   * 2. Crash with OOM error
   * 3. Find an element matching a predicate in LList
   *  ( def find[A](list: LList[A], predicate: Predicate[A]): A ) throws an exception if no element find )
   */

  def main(args: Array[String]): Unit = {
    //println(aString.length)
    //println(potentialFail)
    //val throwMyException = throw MyException()

    // crash with SO error

   /* def crashingWithSOError(value: Int): Int = {
      crashingWithSOError(value + 1) + crashingWithSOError(value + 1)
    }
    crashingWithSOError(1)*/

    // crash with OutOfMemory Error
    /*def oomCrash(n: Int, acc: String): String =
      if(n == 0) acc
      else oomCrash(n-1, acc + acc)

    oomCrash(10000000,"ABCHGUFUE")*/

  }

}
