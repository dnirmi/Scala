import scala.io.StdIn.readLine

object numberClassifier extends App{

    def classifyNumber : Int => String ={
            case n if n <= 0 => "Negative/Zero is input"
            case n if n % 2 == 0 => "Even number is given"
            case n => "Odd number is given"
    }

    println("Enter the integer: ")
    val input= readLine()
    val num = input.toInt
    println(classifyNumber(num))
}