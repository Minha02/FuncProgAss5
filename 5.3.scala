object Fibonnaci{
    def fibonacciRecursive(n: Int):Int = {
        if(n<=1) n
        else fibonacciRecursive(n-1) + fibonacciRecursive(n-2)
    }

    def fibonnacciIterative(n: Int): List[Int] ={
        require(n>=0, "Number of terms must me non-negative")
        if(n==0) List(0)
        else if (n==1) List(0,1)
        else{
            var fibs: List[Int] = List(0,1)
            for(i<- 2 until n){
                fibs = fibs :+ (fibs(i-1) + fibs(i-2))
            }
            fibs
        }
    }

    def printFibonacci(n: Int): Unit ={
        val fibs = fibonnacciIterative(n)
        println(s"The first $n Fibonacci numbers are:")
        fibs.foreach(println)
    }

    def main(args: Array[String]): Unit = {
    println("Enter the number of Fibonacci terms to generate:")
    val n = scala.io.StdIn.readInt()
    printFibonacci(n)
  }

}