import scala.io.StdIn

object StudentRecordApp extends App {


  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.trim.isEmpty) {
      (false, Some("Name cannot be empty."))
    } else if (marks < 0 || totalMarks <= 0) {
      (false, Some("Marks and total possible marks must be positive integers."))
    } else if (marks > totalMarks) {
      (false, Some("Marks cannot exceed total possible marks."))
    } else {
      (true, None)
    }
  }


  def getStudentInfo: (String, Int, Int, Double, Char) = {
    println("Enter student's name:")
    val name = StdIn.readLine().trim

    println("Enter marks obtained:")
    val marks = StdIn.readInt()

    println("Enter total possible marks:")
    val totalMarks = StdIn.readInt()


    validateInput(name, marks, totalMarks) match {
      case (true, _) =>
        val percentage = (marks.toDouble / totalMarks) * 100
        val grade = percentage match {
          case p if p >= 90 => 'A'
          case p if p >= 75 => 'B'
          case p if p >= 50 => 'C'
          case _ => 'D'
        }
        (name, marks, totalMarks, percentage, grade)
      case (false, Some(errorMessage)) =>
        println(s"Error: $errorMessage")
        getStudentInfo
    }
  }

  def printStudentRecord(studentRecord: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = studentRecord
    println(s"Student Name: $name")
    println(s"Marks Obtained: $marks")
    println(s"Total Possible Marks: $totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }


  def getStudentInfoWithRetry: (String, Int, Int, Double, Char) = {
    getStudentInfo 
  }


  val studentRecord = getStudentInfoWithRetry
  printStudentRecord(studentRecord)
}
