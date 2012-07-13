#!/bin/sh
exec scala "$0" "$@"
!#
/*
http://amirrajan.net/Blog/code-katas-bowling-kata
*/

object Bowling extends App {

  def calc(score: String): Int = {
    var sum = 0
    var even = false
    var last2 = 0
    for (c <- score) {
      if (!even) {
        last2 = 0
      }
      val curr = ("" + c).toInt
      last2 += curr
      sum += curr * (if (last2 == 10) 2 else 1)
      even = !even
    }
    sum
  }

  def myAssert(actual: Any, expected: Any, message: String) {
    assert(expected == actual, "%s - failed. Expected: %s, actual: %s".format(message, expected, actual))
    Console.println(message.formatted("%s - ok"))
  }

  myAssert(calc("31415390107133238009"), 63, "first test")
  myAssert(calc("91415390107133238009"), 73, "spare")
}

Bowling.main(args)