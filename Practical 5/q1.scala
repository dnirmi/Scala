import scala.io.StdIn.readLine

object InventoryManagement extends App {


  def getProductList(): List[String] = {
    def getProductListRec(products: List[String]): List[String] = {
      val product = readLine("Enter a product name (or type 'done' to finish): ")
      if (product.toLowerCase == "done") products
      else getProductListRec(products :+ product)
    }

    getProductListRec(Nil)
  }

  
  def printProductList(products: List[String]): Unit = {
    products.zipWithIndex.foreach { case (product, index) =>
      println(s"${index + 1}. $product")
    }
  }

 
  def getTotalProducts(products: List[String]): Int = {
    products.length
  }

  var productList: List[String] = List()

  var continue = true
  while (continue) {
    println("\nMain Menu")
    println("1. Enter new products")
    println("2. Display Inventory")
    println("3. Get total number of products")
    println("4. Exit")
    println("Enter your choice: ")

    val choice = readLine().toInt
    choice match {
      case 1 =>
        productList = getProductList()
      case 2 =>
        println("\nProduct List:")
        printProductList(productList)
      case 3 =>
        println(s"\nTotal number of products: ${getTotalProducts(productList)}")
      case 4 =>
        continue = false
        println("Exiting the program")
      case _ =>
        println("Invalid choice. Choose a number between 1 to 4.")
    }
  }
}
