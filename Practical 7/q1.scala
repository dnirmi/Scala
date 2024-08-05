import scala.io.StdIn.readLine

object EvenNumbers extends App {

  def filterEvenNumbers(numbers: List[Int]): List[Int] = {
    numbers.filter(number => number % 2 == 0)
  }

  println("Enter a list of integers separated by spaces: ")
  val input = readLine()
  val nums = input.split(" ").map(_.toInt).toList
  val evenNums = filterEvenNumbers(nums)
  println(s"Even numbers: ${evenNums.mkString(" ")}")
}
