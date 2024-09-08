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
  }

  object Rational {
    def apply(numerator: Int, denominator: Int): Rational = new Rational(numerator, denominator)
  }

  val x = Rational(1, 2)

  println(x) 

  val negX = x.neg

  println(negX) 
}