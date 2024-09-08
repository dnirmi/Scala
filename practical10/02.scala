object RationalApp extends App {
  class Rational(numerator: Int, denominator: Int) {
    require(denominator != 0, "Denominator cannot be zero")

    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b)
    }

    private val gcdValue = gcd(numerator, denominator)
    val normalizedNumerator = numerator / gcdValue
    val normalizedDenominator = denominator / gcdValue

    override def toString: String = s"$normalizedNumerator/$normalizedDenominator"

    def neg: Rational = new Rational(-normalizedNumerator, normalizedDenominator)

    def sub(other: Rational): Rational = {
      val leastCommonMultiple = lcm(normalizedDenominator, other.normalizedDenominator)
      val newNumerator = (leastCommonMultiple / normalizedDenominator) * normalizedNumerator - 
                         (leastCommonMultiple / other.normalizedDenominator) * other.normalizedNumerator
      new Rational(newNumerator, leastCommonMultiple)
    }


    private def lcm(a: Int, b: Int): Int = {
      if (a == 0 || b == 0) {
        throw new ArithmeticException("Cannot calculate LCM of zero")
      }
      (a * b) / gcd(a, b)
    }
  }

  object Rational {
    def apply(numerator: Int, denominator: Int): Rational = new Rational(numerator, denominator)
  }

  val x = Rational(3, 4)
  val y = Rational(5, 8)
  val z = Rational(2, 7)

  println(s"x = $x")
  println(s"y = $y")
  println(s"z = $z")


  try {
    val result = x.sub(y.sub(z)) 
    println(s"x - (y - z) = $result")
  } catch {
    case e: ArithmeticException => println(s"Error: ${e.getMessage}")
  }
}
