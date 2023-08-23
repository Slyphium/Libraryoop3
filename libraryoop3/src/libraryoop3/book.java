package libraryoop3;

public class book {
    private String title;
    private boolean isBorrowed;

    // Constructor to initialize the book with a title
    public book(String bookTitle) {
        title = bookTitle;
        isBorrowed = false;
    }

    // Get the title of the book
    public String getTitle() {
        return title;
    }

    // Check if the book is available
    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Borrow the book
    public boolean borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            return true;
        } else {
            return false;
        }
    }

    // Return the book
    public void returned() {
        isBorrowed = false;
    }

    public static void main(String[] args) {
        // Create a book
        book exampleBook = new book("The Da Vinci Code");

        // Test the book's methods
        System.out.println("Title (should be The Da Vinci Code): " + exampleBook.getTitle());
        System.out.println("Rented? (should be false): " + exampleBook.isBorrowed());
        System.out.println("Rented? (should be true): " + exampleBook.borrow());
        System.out.println("Rented? (should be false): " + exampleBook.isBorrowed());
        exampleBook.returned();
        System.out.println("Rented? (should be false): " + exampleBook.isBorrowed());
    }
}
