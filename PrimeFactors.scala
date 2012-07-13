#!/bin/sh
exec scala "$0" "$@"
!#
/*
http://amirrajan.net/Blog/code-katas-prime-factors
*/

//import scala.math._
import scala.annotation.tailrec

object PrimeFactors extends App {
  @tailrec private def expand(num: Int, i: Int, result: List[Int]): List[Int] = {
    if (num > 1)
      if (num % i == 0) 
        expand(num / i, i, i :: result)
      else
        expand(num, i + 1, result)
    else 
      result reverse
  }

  def expand (num: Int): List[Int] = {
    if (num == Int.MaxValue) 
      List(Int.MaxValue)
    else 
      expand(num, 2, List())
  }   

  def myAssert(actual: Any, expected: Any, message: String) {
    assert(expected == actual, "%s - failed. Expected: %s, actual: %s".format(message, expected, actual))
    Console.println(message.formatted("%s - ok"))
  }

  myAssert(expand(0), List(), "0")
  myAssert(expand(1), List(), "1")
  myAssert(expand(2), List(2), "2")
  myAssert(expand(3), List(3), "3")
  myAssert(expand(4), List(2,2), "4")
  myAssert(expand(5), List(5), "5")
  myAssert(expand(6), List(2,3), "6")
  myAssert(expand(9), List(3,3), "9")
  myAssert(expand(Int.MaxValue), List(Int.MaxValue), "MaxInt")
}

PrimeFactors.main(args)