package com.rockthejvm.part1basics

import scala.annotation.tailrec

object DefaultArgs {

  @tailrec //it will validate whether the recursive call happens last in the code path
  def sumUntilTailRec(x: Int, accumulator: Int = 0): Int =
    if (x <= 0) accumulator
    else sumUntilTailRec(x - 1, x + accumulator)

  val sumUntil100 = sumUntilTailRec(100)  // additional arg passed automatically

  //when you use function most of the tine with the same value = default arguments
  def savePicture(dirPath: String, name: String, format: String = "jpg", width: Int = 1920, height: Int = 1080 ): Unit =
    println("Saving Picture in format " + format + " in path " + dirPath)


  def main(args: Array[String]): Unit = {
    // default args are injected
    savePicture("users/parneet/photos", "myPhotos")
    // pass explicit different values for default args
    savePicture("users/parneet/photos", "myPhotos", "png")
    // pass values after the default argument
    savePicture("users/parneet/photos", "myPhotos", width = 800, height = 600 )
    // naming argument allow passing in a different order
    savePicture("users/parneet/photos", "myPhotos", height = 600, width = 800 )
  }

}
