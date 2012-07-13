#!/bin/sh
exec scala "$0" "$@"
!#
/*
http://amirrajan.net/Blog/code-katas-bowling-kata
*/

object Bowling extends App {

  def calc(score: String): Int = {
    var sum = 0
    for (c <- score) {
      sum += ("" + c).toInt
    }
    sum
  }

  def myAssert(actual: Any, expected: Any, message: String) {
    assert(expected == actual, "%s - failed. Expected: %s, actual: %s".format(message, expected, actual))
    Console.println(message.formatted("%s - ok"))
  }

  myAssert(calc("31415390107133238009"), 63, "first test")
}

Bowling.main(args)