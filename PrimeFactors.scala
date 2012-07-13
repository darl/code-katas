/*
http://amirrajan.net/Blog/code-katas-prime-factors
*/

import scala.math._

object PrimeFactors extends App {
	def expand (num: Int): Seq[Int] = {
		var n = num
		var i = 2
		var result:List[Int] = List()
		while (i <= round(sqrt(num.toDouble))) {
			if (n % i == 0) {
				n = n / i
				result = i :: result
			} else {
				i += 1
			}
		}
		result.reverse
	}	

	Console.printf(String.valueOf(expand(4)))
}

PrimeFactors.main(args)