import scala.io.StdIn.readLine

object sortStrings extends App{

    var inputStrings= List[String]()
    var continue=true


    println("Enter the list of strings (type 'stop' to quit):")
    while (continue){
        val input=readLine()
        if (input.toLowerCase== "stop"){
                continue=false
        }else{
                inputStrings=inputStrings :+ input
        }
    }
    println("Strings with the length greater than 5:")
    inputStrings.foreach { str =>
        if (str.length >5)
            println(s"$str")
        
    }
  
}