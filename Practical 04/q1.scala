import scala.io.StdIn.readLine

object inventory extends App{

    var item:Array[String]=Array("apple","banana","orange")
    var quantity:Array[Int]=Array(200,160,170)

    
    def displayinv():Unit={
        println("Current Inventory")
        for(i<-item.indices){
            println(s"${item(i)}  ${quantity(i)}")
        }
    }

    def restock(itemname:String,quant:Int):Unit={
        val index=item.indexOf(itemname)
        if(index>=0){
            quantity(index)+=quant
            println(s"Restocked quantity ${quant} of ${itemname}.new quantity: ${quantity(index)} ")
        }
        else{
            println(s"${itemname} not found")
        }

    }

    def sellitem(itemname:String,quant:Int):Unit={
        val index=item.indexOf(itemname)
        if(index>=0){
            if(quantity(index)>=quant){
                quantity(index)-=quant
                println(s"Sold ${quant} items from ${itemname}.New quantity: ${quantity(index)}")
            }
            else{
                println(s"Not enough ${itemname} quantity in the stocks")
            }
        }
        else{
            println(s"${itemname} not found")
        }
        
    }

    var continue=true
        while(continue){
            println(s"\nMain Menu \nEnter")
            println("1.Display Inventory")
            println("2.Restock Items")
            println("3.Sell Items")
            println("4.Exit")
            println("Enter your choice: ")

            val choice=readLine().toInt
            choice match{
                case 1=>
                    displayinv()

                case 2=>
                    println("Enter item name to restock: ")
                    val itemname=readLine()
                    println("Enter quantity: ")
                    val quant=readLine().toInt
                    restock(itemname,quant)

                case 3=>
                    println("Enter item name to sell: ")
                    val itemname=readLine()
                    println("Enter quantity: ")
                    val quant=readLine().toInt
                    sellitem(itemname,quant)

                case 4=>
                    continue=false
                    println("Exiting the program")

                case _=>
                    println("Invalid choice.Choose number between 1 to 4")
            }
        }

    

}