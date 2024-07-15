import scala.io.StdIn.readLine

case class Book(title: String, author: String, isbn: String)

object LibraryManagement extends App {

  var library: Set[Book] = Set(
    Book("Prisoner Of Azkaban", "J.K.Rowling", "1000"),
    Book("Prince And The Pauper", "Mark Twain", "1001"),
    Book("Oliwer Twist", "Charles Dickens", "1002")
  )

  
  def addBook(book: Book): Unit = {
    if (library.exists(_.isbn == book.isbn)) {
      println("A book with this ISBN already exists in the library.")
    } else {
      library += book
      println("Book added successfully.")
    }
  }


  def removeBook(isbn: String): Unit = {
    val bookOpt = library.find(_.isbn == isbn)
    bookOpt match {
      case Some(book) =>
        library -= book
        println(s"Book with ISBN $isbn removed successfully.")
      case None =>
        println(s"No book found with ISBN $isbn.")
    }
  }

  
  def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  
  def displayLibrary(): Unit = {
    println("\nCurrent Library Collection:")
    library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
  }

  
  def searchByTitle(title: String): Unit = {
    val bookOpt = library.find(_.title.equalsIgnoreCase(title))
    bookOpt match {
      case Some(book) =>
        println(s"Book found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None =>
        println(s"No book found with title $title.")
    }
  }

  
  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.nonEmpty) {
      println(s"\nBooks by $author:")
      booksByAuthor.foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
    } else {
      println(s"No books found by author $author.")
    }
  }

  
  var continue = true
  while (continue) {
    println("\nLibrary Management System")
    println("1. Display Library Collection")
    println("2. Add New Book")
    println("3. Remove Book by ISBN")
    println("4. Search Book by Title")
    println("5. Display Books by Author")
    println("6. Exit")
    print("Enter your choice: ")

    val choice = readLine().toInt
    choice match {
      case 1 =>
        displayLibrary()
      case 2 =>
        print("Enter book title: ")
        val title = readLine()
        print("Enter book author: ")
        val author = readLine()
        print("Enter book ISBN: ")
        val isbn = readLine()
        addBook(Book(title, author, isbn))
      case 3 =>
        print("Enter ISBN of the book to remove: ")
        val isbn = readLine()
        removeBook(isbn)
      case 4 =>
        print("Enter title of the book to search: ")
        val title = readLine()
        searchByTitle(title)
      case 5 =>
        print("Enter author name to display books: ")
        val author = readLine()
        displayBooksByAuthor(author)
      case 6 =>
        continue = false
        println("Exiting the program")
      case _ =>
        println("Invalid choice. Choose a number between 1 to 6.")
    }
  }
}
