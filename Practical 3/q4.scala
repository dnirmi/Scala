import scala.io.StdIn.readLine

object sortStrings extends App{

    var inputIntegers= List[Int]()
    var continue=true


    println("Enter the list of integers (type 'stop' to quit):")
    while (continue){
        val input=readLine()
        if (input.toLowerCase()== "stop"){
                continue=false
        }else{
                val number = input.toInt
                inputIntegers=inputIntegers :+ number
        }
    }

    var sumofEvens=0

    inputIntegers.foreach { num =>
        if (num%2 == 0){
            sumofEvens += num
        }
    }

    println(s"Sum of even numbers in the list: $sumofEvens")

        
}