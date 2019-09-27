object bc {

  def validInt(a: Int): Boolean = {
    var b = a
    var result: Boolean = true

    var firstDigit = b / 100
    b = b - firstDigit * 100
    var secondDigit = b / 10
    b = b - secondDigit * 10
    var thirdDigit = b

    (if ((firstDigit == secondDigit) | (firstDigit == thirdDigit) |
      (secondDigit == thirdDigit)) { result = false })

    (if ((firstDigit == 0) | (secondDigit == 0) | (thirdDigit == 0)) { result = false })

    result
  }

  def main(args: Array[String]): Unit = {
    var nTrials = 100000
    val r = scala.util.Random
    var tmp = 0
    val heuNumber = 9 * 8 * 7
    (println("In 3-digits BC the heuristic number of valid numbers is " +
      heuNumber))
    var countValid = 0

    for (i <- 1 to nTrials) {
      tmp = r.nextInt(1000)
      if (validInt(tmp)) { countValid += 1 }
    }

    var ratio: Float = countValid / nTrials.toFloat
    (println("Empirical number of valid numbers in " + nTrials + " trials is " +
      Math.round(ratio * 1000)))
  }

}
