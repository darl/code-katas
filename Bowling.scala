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
    var doubles = 0
    var last2 = 0
    for (c <- score) {
      if (!even) {
        last2 = 0
      }
      val curr = if (c == 'X') 10 else if (c == '-') 0 else ("" + c).toInt
      last2 += curr
  
      sum += curr * (if (doubles > 0) 2 else 1)
      doubles = if (doubles == 0) 0 else doubles - 1
      if (last2 >9) doubles += 1
      if (c == '-') doubles += 1
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
  myAssert(calc("X-415390107133238009"), 74, "strike")
}

Bowling.main(args)