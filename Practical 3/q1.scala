import scala.io.StdIn.readLine

object reverseString extends App{
        println("Enter a string :")
        val inputstring = readLine()

        val reversedString = reverse(inputstring)
        println(s"Reversed string: $reversedString")

        def reverse(s: String): String= {
            if(s.isEmpty) "" else reverse(s.tail)+ s.head
    }
    
}

