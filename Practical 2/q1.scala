object EvaluateExpressions extends App{
    var i, j, k = 2
    val m, n = 5
    val f = 12.0f
    val g = 4.0f
    val c = 'X'

    val A = k + 12 * m
    val B = m / j
    val C = n % j
    val D = m / j * j
    val E = f + 10 * 5 + g

    i += 1
    val F = i * n

    println(s"a) k + 12 * m = $A")
    println(s"b) m / j = $B")
    println(s"c) n % j = $C")
    println(s"d) m / j * j = $D")
    println(s"e) f + 10*5 + g = $E")
    println(s"f) ++i * n = $F")
  }

