package libraryoop3;

public class Library {
    private String address;
    private static final String openingHours = "Libraries are open daily from 9am to 5pm.";
    private book[] catalog;

    // Constructor to create a library with a given address
    public Library(String libraryAddress) {
        address = libraryAddress;
        catalog = new book[0]; // Initialize an empty catalog
    }

    // Add a book to the library's catalog
    public void addBook(book book) {
        book[] newCatalog = new book[catalog.length + 1];
        System.arraycopy(catalog, 0, newCatalog, 0, catalog.length);
        newCatalog[catalog.length] = book;
        catalog = newCatalog;
    }

    // Print the library's opening hours
    public static void printOpeningHours() {
        System.out.println(openingHours);
    }

    // Print the library's address
    public void printAddress() {
        System.out.println(address);
    }

    // Borrow a book from the library
    public boolean borrowBook(String bookTitle) {
        for (book book : catalog) {
            if (book.getTitle().equals(bookTitle)) {
                if (!book.isBorrowed()) {
                    return book.borrow();
                } else {
                    System.out.println("Sorry, this book is already borrowed.");
                    return false;
                }
            }
        }
        System.out.println("Sorry, this book is not in our catalog.");
        return false;
    }

    // Return a book to the library
    public void returnBook(String bookTitle) {
        for (book book : catalog) {
            if (book.getTitle().equals(bookTitle)) {
                book.returned();
                System.out.println("You successfully returned " + bookTitle);
                return;
            }
        }
    }

    // Print the books available in the library's catalog
    public void printAvailableBooks() {
        if (catalog.length == 0) {
            System.out.println("No book in catalog");
        } else {
            for (book book : catalog) {
                if (!book.isBorrowed()) {
                    System.out.println(book.getTitle());
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add books to the catalog of the first library
        firstLibrary.addBook(new book("The Da Vinci Code"));
        firstLibrary.addBook(new book("Le Petit Prince"));
        firstLibrary.addBook(new book("A Tale of Two Cities"));

        // Print library information
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();

        // Borrow and return books
        System.out.println("Borrowing The Lord of the Rings:");
        if (firstLibrary.borrowBook("The Lord of the Rings")) {
            System.out.println("You successfully borrowed The Lord of the Rings");
        }
        if (firstLibrary.borrowBook("The Lord of the Rings")) {
            System.out.println("You successfully borrowed The Lord of the Rings");
        }
        firstLibrary.borrowBook("Harry Potter"); // Book not in catalog
        firstLibrary.returnBook("The Lord of the Rings");

        // Print available books
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();

        // Return The Lord of the Rings
        firstLibrary.returnBook("The Lord of the Rings");

        // Print available books again
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
