object StringFOrmatter:

  def toUpper(input: String): String =
    input.map { char =>
      if (char >= 'a' && char <= 'z') (char - 32).toChar else char
    }

  def toLower(input: String): String =
    input.map { char =>
      if (char >= 'A' && char <= 'Z') (char + 32).toChar else char
    }

  def formatNames(name: String)(formatFunction: String => String): String =
    formatFunction(name)

  def main(args: Array[String]): Unit =
    println(formatNames("Benny")(toUpper))         // Benny -> BENNY
    println(formatNames("Niroshan") { name =>
      toUpper(name.substring(0, 2)) + toLower(name.substring(2))
    })                                             // Niroshan -> NIroshan
    println(formatNames("Saman")(toLower))         // Saman ->saman
    println(formatNames("Kumara") { name =>
      toUpper(name.substring(0, 1)) + toLower(name.substring(1, 5)) + toUpper(name.substring(5))
    })                                             // Kumara->KumarA
