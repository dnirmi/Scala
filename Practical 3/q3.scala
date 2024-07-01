import scala.io.StdIn.readInt

object findMean extends App{
    print("Enter number 1:")
    val num1=readInt()

    print("Enter number 2:")
    val num2=readInt()

    
    def findmean(num1:Int,num2:Int): Float=
        val mean = (num1+num2).toFloat / 2
        return mean


    printf("Mean of the to numbers(rounded to two decimal places): %.2f", findmean(num1,num2))
}