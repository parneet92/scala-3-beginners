package com.rockthejvm.part2oop

object AccessModifiers {

  class Person(val name: String){
    // protected == access to inside the class + children classes
    protected def sayHi(): String = s"Hi my name is $name"
    // it can only be called within person class
    private def watchNetflix(): String = "I'm binge watching my favorite series"
  }

  class Kid(override val name: String, age: Int) extends Person(name){
    def greetPolitely(): String = sayHi() + "I love to play"    // no modifier = "public"
  }

  val aPerson = new Person("Alice")
  val aKid = Kid("David", 25)

  //complication
  class KidWithParent(override val name: String, age: Int, momName: String, dadName: String) extends Person(name){
    val mom = new Person(momName)
    val dad = new Person(dadName)

    /* this is not legal as mom and dad instance can't call say hi outside the scope
    def everyoneSayHi(): String =
      this.sayHi() + s"Hi, I'm $name, and here are my parents: "+ mom.sayHi() + dad.sayHi()

     */
  }

  def main(args: Array[String]): Unit = {
    //println(aPerson.sayHi())    // protected method can only be called with its own class and its children
    println(aKid.greetPolitely())
  }

}
