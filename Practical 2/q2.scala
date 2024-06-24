object EvaluateExpressions extends App {
  var a = 2
  var b = 3
  var c = 4
  var d = 5
  val k = 4.3f
  val g = 10 

  
  b -= 1
  val A = b * a + c * d
  
  d -= 1

  
  val B = a
  a += 1

  
  val C = -2 * (g - k) + c

  
  val D = c
  c += 1

  
  c += 1
  val E = c * {
    val temp = a
    a += 1
    temp
  }

  println(s"a) --b * a + c * d-- = $A")
  println(s"b) a++ = $B")
  println(s"c) -2 * (g - k) + c = $C")
  println(s"d) c++ = $D")
  println(s"e) ++c * a++ = $E")
}
