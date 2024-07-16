case class Book(title: String, author: String, isbn: String)

Object LibraryManager{
    var library:Set[Book] = Set(
        Book("123","Autor1","978-0-06-112008-4")
        Book("ABCD", "Author2", "978-0-452-28423-4"),
        Book("XYZ", "Author3", "978-0-7432-7356-5")
    )

    def addBook(book: Book):Unit ={
        library += book
    }

    def removeBook(isbn: String):Unit = {
        library = library.filterNot(_.isbn == isbn)
    }

    def isBookInLibrary(isbn: String):Boolean ={
        library.exists(_.isbn == isbn)
    }

    def displayLibrary(): Unit ={
        library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
    }

    def searchBookByTitle(title: String) : Option[Book] ={
        library.find(_.title.equalsIgnoreCase(title))
    }

    def displayBooksByAuthor(author:String):Unit ={
        library.filter(_.author.equalsIgnoreCase(author)).foreach(book => println(s"Title: ${book.title},ISBN: ${book.isbn}"))
    }

    def main(args: Array[String]): Unit = {
    println("Initial Library Collection:")
    displayLibrary()

    println("\nAdding a new book:")
    addBook(Book("Brave New World", "Aldous Huxley", "978-0-06-085052-4"))
    displayLibrary()

    println("\nRemoving a book with ISBN '978-0-452-28423-4':")
    removeBook("978-0-452-28423-4")
    displayLibrary()

    println("\nChecking if a book with ISBN '978-0-06-112008-4' is in the library:")
    println(isBookInLibrary("978-0-06-112008-4"))

    println("\nSearching for a book with title '1984':")
    searchBookByTitle("1984").foreach(book => println(s"Found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))

    println("\nDisplaying all books by 'Harper Lee':")
    displayBooksByAuthor("Harper Lee")
  }
}