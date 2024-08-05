import scala.io.StdIn.readLine

object FilterPrime extends App {

  def isPrime(n: Int): Boolean = {
    if (n <= 1) false
    else {
      for (i <- 2 to n / 2) {
        if (n % i == 0) 
          return false
      }
      true
    }
  }

  def filterPrime(numbers: List[Int]): List[Int] = {
    numbers.filter(isPrime)
  }

  println("Enter a list of integers separated by space: ")
  val input = readLine()
  val nums = input.split(" ").map(_.toInt).toList
  val primeNums = filterPrime(nums)
  println(s"Prime numbers: ${primeNums.mkString(" ")}")
}
