
  def main(args: Array[String]): Unit ={
    print("Please enter an integer :")
    
    val input = scala.io.StdIn.readInt()


    def patternMatching(number:Int):String= number match{
        case x if (number <= 0) => "Negative/Zero"
        case x if (number%2==0) => "Even number is given"
        case _ => "Odd number is given"
    }


    println(s"${input} -> ${patternMatching(input)}")
}
