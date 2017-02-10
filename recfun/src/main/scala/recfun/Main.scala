package recfun

object Main {
	def main(args: Array[String]) {
		println("Pascal's Triangle")
		for (row <- 0 to 10) {
			for (col <- 0 to row)
				print(pascal(col, row) + " ")
			println()
		}
	}

	/**
		* Exercise 1
		*/
	def pascal(c: Int, r: Int): Int = {
		if (c == 0 || r == c)
			return 1
		pascal(c - 1, r - 1) + pascal(c, r - 1)
	}

	/**
		* Exercise 2
		*/
	def balance(chars: List[Char]): Boolean = {
		def tailBalance(chars: List[Char], open: Int): Boolean = {
			if (chars.isEmpty)
				open == 0
			else
				chars.head match {
					case '(' =>
						tailBalance(chars.tail, open + 1)
					case ')' =>
						open > 0 && tailBalance(chars.tail, open - 1)
					case _ =>
						tailBalance(chars.tail, open)
				}
		}

		tailBalance(chars, 0)
	}

	/**
		* Exercise 3
		*/
	def countChange(money: Int, coins: List[Int]): Int =
		coins match {
			case h :: t if money > 0 =>
				countChange(money - h, h :: t) + countChange(money, t)
			case _ =>
				if (money == 0)
					1 else 0

		}
}
