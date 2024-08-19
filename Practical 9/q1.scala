import scala.io.StdIn.readLine

object findInterest extends App{

    def calculateInterest : Double => Double = {
        case amount if amount <=20000 => amount*0.02
        case amount if amount <= 200000 => amount * 0.04
        case amount if amount <= 2000000 => amount * 0.035
        case amount => amount * 0.065
    }

    println("Enter the amount: ")
    val input=readLine()
    val amount=input.toDouble
    println("The interest amount is: ")
    println(calculateInterest(amount))

}