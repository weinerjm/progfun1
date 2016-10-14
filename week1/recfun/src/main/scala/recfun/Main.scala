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
      // sum the number above and the number up and to the left
      // (think of the triangle as left-justified)
      if (c == 0 || c == r || r == 0) 1
      else pascal(c, (r-1)) + pascal((c-1), (r-1))
    }

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      // use helper function to keep track of number open parentheses
      def balance_helper(chars: List[Char], nopen: Int): Boolean = {
        if (chars.isEmpty) (nopen == 0) // at end of list
        else
          if (chars.head == '(') balance_helper(chars.tail, nopen+1)
            else
              // (nopen > 0) makes sure ')' comes after at least one '('
              if (chars.head == ')') (nopen > 0) && balance_helper(chars.tail, nopen-1)
              else balance_helper(chars.tail, nopen)
      }
      balance_helper(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (coins.isEmpty || money < 0) 0 // no more coins left or no more money left
        else
          if (money == 0) 1
          else countChange(money-coins.head, coins) + countChange(money, coins.tail)
      }
  }
