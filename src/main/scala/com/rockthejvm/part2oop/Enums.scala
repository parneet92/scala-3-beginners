package com.rockthejvm.part2oop

import com.rockthejvm.part2oop.Enums.Permissions.READ

// prior to scala 3 it was a headache
object Enums {

  enum Permissions{
    case READ, WRITE, EXECUTE, NONE

    // add fields/methods
    def openDocument(): Unit =
      if(this == READ) println("Opening Document...")
      else println("Reading not allowed")
  }

  val somePermissions: Permissions = Permissions.READ

  // constructor args
  enum PermissionWithBits(bits: Int) {
    case READ extends PermissionWithBits(4) // 100
    case WRITE extends PermissionWithBits(2)  // 010
    case EXECUTE extends PermissionWithBits(1)  // 001
    case NONE extends PermissionWithBits(0) // 000
  }

  object PermissionWithBits {
    def fromBits(bits: Int): PermissionWithBits = //whatever
      PermissionWithBits.NONE
  }

  // standard API
  val somePermissionOrdinals = somePermissions.ordinal
  val allPermissionWithBits = PermissionWithBits.values   // array of all possible values of the enum
  val readPermission: Permissions = Permissions.valueOf("READ")

  def main(args: Array[String]): Unit = {
    somePermissions.openDocument()
    println(somePermissionOrdinals)
    println(readPermission)
  }

}
