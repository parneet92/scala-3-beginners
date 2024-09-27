package com.rockthejvm.part1basics

object Expressions {

  //expressions are structures that can be evaluated to a value
  val expressionOfLife = 40 + 2   //( 40 + 2) is an expression

  // mathematical expressions: +, /, -, *, bitwise |, &, <<, >>, >>> (right shift with zero extension)
  val mathExpression = 2 + 3 * 4

  //comparison expression : <, > ,<=, >=, ==, !=
  val equalityTest = 1 == 2

  //boolean expressions: !, ||, &&
  val nonEqualityTest = !equalityTest

  //instructions (like JAVA, C++, do this do that and repeat some more, they are executed )  vs expressions
  //expressions are evaluated, instructions are executed
  //we think in terms of expressions

  //ifs are expressions
  val aCondition = true
  val anIfExpression = if(aCondition) 45 else 99

  //code blocks ( they are also expressions )
  val aCodeBlock  = {
    //local values
    val localValue = 78
    //expressions ....

    //last expression = value of the code block
    localValue + 56
  }

  //everything is an expression

  /**
   * Exercise : without running the code, what do you think the values will print out??
   */

  //1
  val someValue = {
    2 < 3
  }

  //2
  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }

  //3
  val yetAnotherValue = println("Scala")    //type Unit is like void
  val theUnit: Unit = ()      // that's the only value Unit type can hold


  def main(args: Array[String]): Unit = {
    println(someValue)
    println(someOtherValue)
    println(yetAnotherValue)
  }
}
