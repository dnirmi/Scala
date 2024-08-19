object StringFormatter extends App{

  def toUpper(input: String): String = input.toUpperCase

  def toLower(input: String): String = input.toLowerCase

  def formatNames(name: String)(formatFunction: String => String): String = {
    formatFunction(name)
  }

    println(formatNames("Benny")(toUpper))         
    println(formatNames("Niroshan") { name =>
      toUpper(name.substring(0, 2)) + toLower(name.substring(2))
    })                                              
    println(formatNames("Saman")(toLower))          
    println(formatNames("Kumara") { name =>
      toUpper(name.substring(0, 1)) + toLower(name.substring(1, 5)) + toUpper(name.substring(5))
    })                                             
}
