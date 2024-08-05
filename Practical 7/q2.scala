import scala.io.StdIn.readLine

object CalculateSquare extends App {

  def calculateSquare(numbers: List[Int]): List[Int] = {
    numbers.map(number => number * number)
  }

  println("Enter a list of integers separated by spaces: ")
  val input = readLine()
  val nums = input.split(" ").map(_.toInt).toList
  val squares = calculateSquare(nums)
  println(s"Squares of the input numbers: ${squares.mkString(" ")}")
}
