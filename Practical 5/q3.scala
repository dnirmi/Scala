object FibonacciSequence extends App {


  def fibonacci(n: Int): Int = {
    n match {
      case 0 => 0
      case 1 => 1
      case _ => fibonacci(n - 1) + fibonacci(n - 2)
    }
  }

  def printFibonacciNumbers(n: Int): Unit = {
    for (i <- 0 until n) {
      println(fibonacci(i))
    }
  }


  print("Enter the number of Fibonacci numbers to print: ")
  val num = scala.io.StdIn.readInt()

  printFibonacciNumbers(num)
}
