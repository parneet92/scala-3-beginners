package com.rockthejvm.part2oop

import scala.language.postfixOps

object MethodNotation {

  class Person(val name: String, val age: Int, val favoriteMovie: String) {
    infix def likes(movie: String): Boolean =     //infix is the modifier, only applicable for method with single argument
      movie == favoriteMovie

    infix def +(person: Person): String =
      s"${this.name} is hanging out with ${person.name}"

    infix def !!(progLanguage: String): String =
      s"$name wonders how can $progLanguage be so cool!"

    // prefix position
    // unary ops: -, +, ~, !
    // they have to have the below structure
    def unary_- : String =   // make sure leave space between name of method and the colon so that compile can differentiate colon from the method name
      s"$name's alter ego"

    def isAlive: Boolean = true

    def apply(): String =
      s"Hi my name is $name and I really enjoy $favoriteMovie"

    infix def +(nickname: String): Person =
      new Person(s"$name $nickname", this.age, this.favoriteMovie)

    def unary_+ : Person =
      new Person(this.name, this.age+1, this.favoriteMovie)

    def apply(x: Int): String =
      s"$name watched $favoriteMovie $x times"
  }

  val mary = new Person("Mary", 24, "Inception")
  val john = new Person("John", 36, "Fight Club")

  val negativeOne = -1

  /**
   * Exercises
   *  - a + operator on the person class that returns a person with a nickname
   *    mary + "the rockstar" => new Person("Mary the rockstar", _, _)
   *  - a UNARY + operator that increase the person's age
   *    +mary => new Person(_, _, age+1)
   *  - an apply method with an int arg
   *    mary.apply(2) => "Mary watched inception 2 times"
   */

  def main(args: Array[String]): Unit = {
    println(mary.likes("Fight Club"))
    // infix notation - for methods with one argument (In scala 2 you can still use infix for single argument methods without explicitly typing infix in front of method)
    println(mary likes "Fight Club")       //identical

    //"operator" in scala = plain method
    println(mary + john)
    println(mary.+(john))   //identical
    
    println(2 + 3)
    println(2.+(3))   //identical
    
    println(mary !! "Scala")

    // prefix position
    println(-mary)    // calls the unary_- method on mary
    println(mary.unary_-)   // the same

    //postfix notation ( heavily discouraged , its confusing in large codebases )
    println(mary.isAlive)
    println(mary isAlive)   // it's the same as above and only works if the import has been added for postfixops

    // apply is special
    println(mary.apply())
    println(mary())     //same as above

    //exercises
    println((mary + "the rockstar").name)
    println((+mary).age)
    println(mary(5))

  }
}
