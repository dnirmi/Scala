import scala.io.StdIn.readLine

object patternMatch extends App{

    def checkmultiples: Int => String ={
        case n if n%3==0 && n%5==0 => "Multiple of both three and five"
        case n if n%3==0 => "Multiple of three"
        case n if n%5==0 => "Multiple of five"
        case _ =>"Not a multiple of three and five" 
    }

    println("Enter the number: ")
    val input=readLine()
    val nums=input.toInt
    println(checkmultiples(nums))

}