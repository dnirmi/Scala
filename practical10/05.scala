object WordCounterApp extends App {
  def countLetterOccurrences(words: List[String]): Int = {
    if (words.isEmpty) 0
    else words.map(_.length).reduce(_ + _)
  }

  val words = List("apple", "banana", "cherry", "date")
  val totalLetterCount = countLetterOccurrences(words)
  println(s"Total count of letter occurrences: $totalLetterCount")
}