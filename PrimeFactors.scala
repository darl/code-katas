#!/bin/sh
exec scala "$0" "$@"
!#
/*
http://amirrajan.net/Blog/code-katas-prime-factors
*/

import scala.math._

object PrimeFactors extends App {
	def expand (num: Int): Seq[Int] = {
		if (num == Int.MaxValue) {
			List(Int.MaxValue)
		} else {
			var n = num
			var i = 2
			var result = List[Int]()
			while (n > 1) {
				if (n % i == 0) {
					n = n / i
					result = i :: result
				} else {
					i += 1
				}
			}
			result.reverse
		}
	}	

	def myAssert(expected: Any, actual: Any, message: String) {
		assert(expected == actual, message)
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