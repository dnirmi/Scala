import scala.io.StdIn.{readLine, readInt}

object CaesarCipher extends App {

  
  def encryption(plainText: String, shift: Int): String = {
    val shiftedValues: List[Int] = plainText.toList.map(_.toInt).map { value =>
      if (value >= 65 && value <= 90) {  // Uppercase letters
        ((value - 65 + shift) % 26) + 65
      } else if (value >= 97 && value <= 122) {  // Lowercase letters
        ((value - 97 + shift) % 26) + 97
      } else {
        value  // Non-alphabetical characters remain unchanged
      }
    }
    shiftedValues.map(_.toChar).mkString
  }

  
  def decryption(cipherText: String, shift: Int): String = {
    val shiftedValues: List[Int] = cipherText.toList.map(_.toInt).map { value =>
      if (value >= 65 && value <= 90) {  // Uppercase letters
        ((value - 65 - shift + 26) % 26) + 65
      } else if (value >= 97 && value <= 122) {  // Lowercase letters
        ((value - 97 - shift + 26) % 26) + 97
      } else {
        value  
      }
    }
    shiftedValues.map(_.toChar).mkString
  }

  
  print("Would you like to '1-encrypt' or '2-decrypt' a message? ")
  val operation = readInt()

  
  val userInput = readLine("Enter your message: ")


  val shift = 1

  val result = operation match {
    case 1 => encryption(userInput, shift)
    case 2 => decryption(userInput, shift)
    case _ => "Invalid operation. Please choose '1-encrypt' or '2-decrypt'."
  }

  println(s"Result: $result")
}

