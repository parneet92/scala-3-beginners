package com.rockthejvm.practice

import scala.annotation.tailrec

//singly linked list
//[1,2,3] = [1] -> [2] -> [3] -> |
abstract class LList[A] {
  def head: A
  def tail: LList[A]
  def isEmpty: Boolean
  def add(element: A): LList[A] = new Cons(element, this)
  // concatenate
  infix def ++(anotherList: LList[A]): LList[A]
  def map[B](transformer: Transformer[A,B]): LList[B]
  def filter(predicate: Predicate[A]): LList[A]
  def flatMap[B](transformer: Transformer[A, LList[B]]): LList[B]
}

case class Empty[A]() extends LList[A] {
  override def head: A = throw new NoSuchElementException()
  override def tail: LList[A] = throw new NoSuchElementException()
  override def isEmpty: Boolean = true
  override def toString: String = s"[]"
  override def map[B](transformer: Transformer[A, B]): LList[B] = Empty()
  override def filter(predicate: Predicate[A]): LList[A] = this
  override def flatMap[B](transformer: Transformer[A, LList[B]]): LList[B] = Empty()
  override infix def ++(anotherList: LList[A]): LList[A] = anotherList
}

case class Cons[A](override val head: A, override val tail: LList[A]) extends LList[A]{
  override def isEmpty: Boolean = false

  override def toString: String =
    @tailrec
    def concatenatedString(remainder: LList[A], acc: String): String =
      if (remainder.isEmpty) acc
      else concatenatedString(remainder.tail, s"$acc, ${remainder.head}")

    s"[${concatenatedString(tail, s"$head")}]"

  /*
    example
    [1,2,3].map(n*2) =
    new Cons(2, [2,3].map(n*2)) =
    new Cons(2, new Cons(4, [3].map(n*2))) =
    new Cons(2, new Cons(4, new Cons(6, [].map(n*2)))) =
    new Cons(2, new Cons(4, new Cons(6, []))) =
    [2,4,6]
   */
  override def map[B](transformer: Transformer[A, B]): LList[B] =
    Cons(transformer.transform(head), tail.map(transformer))

  /*
  [1,2,3].filter(n%2 == 0) =
  [2,3].filter(n%2 == 0) =
  new Cons(2, [3].filter(n%2==0)) =
  new Cons(2, [].filter(n%2==0)) =
  new Cons(2, []) =
  [2]
   */
  override def filter(predicate: Predicate[A]): LList[A] =
    if(predicate.test(head)) Cons[A](head, tail.filter(predicate))
    else tail.filter(predicate)

  /*
  [1,2,3] ++ [4,5,6]
  new Cons(1, [2,3] ++ [4,5,6]) =
  new Cons(1, new Cons(2, [3] ++ [4,5,6])) =
  new Cons(1, new Cons(2, new Cons(3, [] ++ [4,5,6]))) =
  new Cons(1, new Cons(2, new Cons(3, [4,5,6]))) =
  [1,2,3,4,5,6]
   */
  override infix def ++(anotherList: LList[A]): LList[A] =
    Cons(head, tail ++ anotherList)

  /*
  [1,2,3].flatMap(n => [n, n+1])
  [1,2] ++ [2,3].flatMap(n => [n, n+1]) = 
  [1,2] ++ [2,3] ++ [3].flatMap(n => [n, n+1]) = 
  [1,2] ++ [2,3] ++ [3,4] ++ [].flatMap(n => [n, n+1]) = 
  [1,2,2,3,3,4]
   */
  override def flatMap[B](transformer: Transformer[A, LList[B]]): LList[B] =
    transformer.transform(head) ++ tail.flatMap(transformer)
  
}

/**
 * Exercise: LList extension
 *
 * 1.  Generic trait Predicate[T] with a little method test(T) => Boolean
 * 2.  Generic trait Transformer[A, B] with a method transform(A) => B
 * 3.  LList:
 * - map(transformer: Transformer[A, B]) => LList[B]
 * - filter(predicate: Predicate[A]) => LList[A]
 * - flatMap(transformer from A to LList[B]) => LList[B]
 *
 * class EvenPredicate extends Predicate[Int]
 * class StringToIntTransformer extends Transformer[String, Int]
 *
 * [1,2,3].map(n * 2) = [2,4,6]
 * [1,2,3,4].filter(n % 2 == 0) = [2,4]
 * [1,2,3].flatMap(n => [n, n+1]) => [1,2, 2,3, 3,4]
 */

trait Predicate[T] {
  def test(element: T): Boolean
}

class EvenPredicate extends Predicate[Int] {
  override def test(element: Int): Boolean =
    element % 2 == 0
}

trait Transformer[A,B] {
  def transform(value: A): B
}

class Doubler extends Transformer[Int, Int] {
  override def transform(value: Int): Int =
    value * 2
}

class StringToIntTransformer extends Transformer[String, Int] {
  override def transform(value: String): Int =
    value.toInt
}

class DoublerList extends Transformer[Int, LList[Int]] {
  override def transform(value: Int): LList[Int] = Cons[Int](value, Cons[Int](value+1, Empty()))
}

object LList {
  // find Test
  @tailrec
  def find[A](list: LList[A], predicate: Predicate[A]): A =
    if (list.isEmpty) throw new NoSuchElementException()
    else if (predicate.test(list.head)) list.head
    else find(list.tail, predicate)
}


object LListTest {
  def main(args: Array[String]): Unit = {
    val empty = Empty[Int]()
    println(empty)
    println(empty.isEmpty)

    val first3Numbers = Cons(1, Cons(2, Cons(3, empty)))
    println(first3Numbers)

    val first3Numbers_v2 = empty.add(1).add(2).add(3)
    println(first3Numbers_v2)
    println(first3Numbers_v2.isEmpty)

    val someStrings = Cons("Dogs", Cons("Cats", Empty()))
    println(someStrings)

    val doubler = new Transformer[Int, Int] {
      override def transform(value: Int): Int =
        value * 2
    }

    //map testing
    val numbersDoubled = first3Numbers.map(doubler)
    println(numbersDoubled)

    val numbersNested = first3Numbers.map(new DoublerList)
    println(numbersNested)

    //filter testing
    val evenNumbers = first3Numbers.filter(new EvenPredicate)
    println(evenNumbers)

    //concat testing
    val listInBothWays = first3Numbers ++ first3Numbers_v2
    println(listInBothWays)
    
    //flatmap testing
    val flattened = first3Numbers.flatMap(new DoublerList)
    println(flattened)

    //find Test
    println(LList.find(first3Numbers, EvenPredicate())) //2
    /*println(LList.find(first3Numbers, new Predicate[Int]{
      override def test(element: Int): Boolean = element > 5
    })) // throws a NoSuchElementException*/
  }
}
