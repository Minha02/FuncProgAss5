import scala.io.StdIn.readLine

object InventoryManagement{

    def getProductList(): List[String] = {
        def loop(acc: List[String]): List[String] ={
            val input = readLine("Enter produxt name(or type'done' to finish):")
            if(input.toLowercase == "done") acc
            else loop(acc:+ input)
        }
        loop(Nil)
    }

    def printProductList(products: List[String]): Unit ={
        products.zipWithIndex.foreach{case(product,index) => 
            println()(s"${index+1}.$product")
        }
    }

    def getTotalProducts(products:List[String]) : Int ={
        products.length
    }

    def main(args: Array[String]):Unit ={
        val products = getProductList()
        println("\nProduct List:")
        printProductList(products)
        println("\nTotal number of products : ${getTotalProducts(products)}")
    }


}