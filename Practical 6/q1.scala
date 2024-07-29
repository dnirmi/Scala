import scala.io.StdIn.readLine

object InventorySystem extends App {

  val inventory1: Map[Int, (String, Int, Double)] = Map(
    101 -> ("Pen", 50, 20.00),
    102 -> ("Book", 30, 100.00),
    103 -> ("Pencil", 60, 15.00)
  )

  val inventory2: Map[Int, (String, Int, Double)] = Map(
    102 -> ("Book", 40, 80.00),
    104 -> ("Paper Clip", 150, 5.00)
  )

  def getProductNames(inventory: Map[Int, (String, Int, Double)]): Iterable[String] = {
    inventory.values.map(_._1)
  }

  def getTotalValue(inventory: Map[Int, (String, Int, Double)]): Double = {
    inventory.values.map { case (_, quantity, price) => quantity * price }.sum
  }

  def isInventoryEmpty(inventory: Map[Int, (String, Int, Double)]): Boolean = {
    inventory.isEmpty
  }

  def mergeInventories(
    inv1: Map[Int, (String, Int, Double)],
    inv2: Map[Int, (String, Int, Double)]
  ): Map[Int, (String, Int, Double)] = {
    (inv1.toSeq ++ inv2.toSeq)
      .groupBy(_._1)
      .map { case (productId, entries) =>
        val (name, totalQuantity, highestPrice) = entries.map(_._2).reduce { (acc, product) =>
          (product._1, acc._2 + product._2, acc._3 max product._3)
        }
        productId -> (name, totalQuantity, highestPrice)
      }
  }

  def checkProductById(inventory: Map[Int, (String, Int, Double)], productId: Int): Unit = {
    inventory.get(productId) match {
      case Some((name, quantity, price)) =>
        println(s"Product ID: $productId")
        println(s"Name: $name")
        println(s"Quantity: $quantity")
        println(f"Price: $$${price}%.2f")
      case None =>
        println(s"Product with ID $productId does not exist in the inventory.")
    }
  }

  var continue = true
  while (continue) {
    println("\nMain Menu")
    println("1. Retrieve all product names from Inventory 1")
    println("2. Calculate the total value of all products in Inventory 1")
    println("3. Check if Inventory 1 is empty")
    println("4. Merge Inventory 1 & 2")
    println("5. Check if a product with a specific ID exists and print its details")
    println("6. Exit")
    println("Enter your choice: ")

    val choice = readLine().toIntOption.getOrElse(-1)

    choice match {
      case 1 =>
        val productNames = getProductNames(inventory1)
        println(s"Product names in inventory1: $productNames")
      case 2 =>
        val totalValue = getTotalValue(inventory1)
        println(f"Total value of all products in inventory1: $$${totalValue}%.2f")
      case 3 =>
        val isEmpty = isInventoryEmpty(inventory1)
        println(s"Inventory1 is empty: $isEmpty")
      case 4 =>
        val mergedInventory = mergeInventories(inventory1, inventory2)
        println(s"Merged Inventory: $mergedInventory")
      case 5 =>
        println("Enter the product ID to check:")
        val productIdToCheck = readLine().toIntOption.getOrElse(-1)
        if (productIdToCheck != -1) {
          checkProductById(inventory1, productIdToCheck)
        } else {
          println("Invalid product ID. Please enter a valid number.")
        }
      case 6 =>
        continue = false
        println("Exiting the program")
      case _ =>
        println("Invalid choice. Choose a number between 1 to 6.")
    }
  }
}
