package com.rockthejvm.part2oop

object Generics {

  /*
   If we want to support multiple data types :
  1. We create separate classes like : EmptyINt, NonEmptyInt, EmptyString, NonEmpty String, .... it becomes super cumbersome and unsustainable
  2. To make the MyList which could accept parent of all the datatypes like Any
  Problem( when I want to access the data inside of the list the type would be Any so we basically lost the type safety
  so we don't have guarantee of what to expect
  We want to access our fields with the exact type and not lose the type safety
   */
  /*
  We are defininig the A as a type which we could use inside the class body
   */

  abstract class MyList[A] {
    def head: A
    def tail: MyList[A]
  }

  class Empty[A] extends MyList[A] {    //"generic list" - Java: abstract class MyList<A>
    override def head: A = throw new NoSuchElementException()

    override def tail: MyList[A] = throw new NoSuchElementException()
  }

  class NonEmpty[A](override val head: A, override val tail: MyList[A]) extends MyList[A] {

  }

  val listOfIntegers = new NonEmpty[Int](1, new NonEmpty[Int](2, new Empty[Int]))
  val listOfStrings = new NonEmpty("Scala", new NonEmpty("Java", new Empty))

  val firstNumber = listOfIntegers.head
  val addint = firstNumber + 3

  //multiple generic types
  trait MyMap[K,V]

  //generic methods
  object MyList {
    def from2Elements[A](elem1: A, elem2: A): MyList[A] =
      new NonEmpty[A](elem1, new NonEmpty[A](elem2, new Empty[A]))
  }

  //calling methods
  val first2Numbers = MyList.from2Elements[Int](1, 2)
  val first2Numbers_v2 = MyList.from2Elements(1,2)
  val first2Numbers_v3 = NonEmpty(1, new NonEmpty(2, new Empty))

  /**
   * Exercise : Generalise the Linked List we created in the last lecture
   * @param args
   */
  def main(args: Array[String]): Unit = {

  }
}
