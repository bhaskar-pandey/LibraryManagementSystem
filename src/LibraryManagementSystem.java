import Library.Library;
import books.Book;
import patrons.Patron;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        System.out.println("Welcome to the Library Management System");

        Library library = new Library("City Library 1", "123 India", "999999999");

        // Enroll a patron
        Patron patron1 = library.enrollPatron(1, "John Doe", "8888888888", "john@doe.com");
        Patron patron2 = library.enrollPatron(2, "Jane Smith", "7777777777", "jane@smith.com");

        // Add books to inventory
        Book book1 = library.addBookToInventory(101, "My book 1", "F. Scott Fitzgerald", "9780743273565", 1925);
        Book book2 = library.addBookToInventory(102, "My book 2", "George Orwell", "9780451524935", 1949);

        // Issue books to patrons
        boolean issueStatus1 = library.issueBookToPatron(book1, patron1);
        System.out.println("Book 1 issued to Patron 1: " + issueStatus1);
        boolean issueStatus2 = library.issueBookToPatron(book2, patron2);
        System.out.println("Book 2 issued to Patron 2: " + issueStatus2);

        // Current books issued to Patron 1
        System.out.println("Books currently issued to Patron 1:");
        for (String bookName : library.getBooksIssuedToPatron(patron1)) {
            System.out.println("- " + bookName);
        }
        // Return book from Patron 1
        boolean returnStatus1 = library.returnBookFromPatron(book1, patron1);
        System.out.println("Book 1 returned from Patron 1: " + returnStatus1);

        // Book issue history for Patron 1
        System.out.println("Book issue history for Patron 1:");
        System.out.println(library.getBookIssueHistoryForPatron(patron1));

        // Attempt to issue an unavailable book
        boolean issueStatus3 = library.issueBookToPatron(book2, patron1);
        System.out.println("Book 2 issued to Patron 1: " + issueStatus3);

        // Return book from Patron 2
        boolean returnStatus2 = library.returnBookFromPatron(book2, patron2);
        System.out.println("Book 2 returned from Patron 2: " + returnStatus2);

        // Retry issuing book 1 to Patron 2
        boolean issueStatus4 = library.issueBookToPatron(book2, patron1);
        System.out.println("Book 2 issued to Patron 1: " + issueStatus4);

        // Current books issued to Patron 1
        System.out.println("Books currently issued to Patron 1:");
        for (String bookName : library.getBooksIssuedToPatron(patron1)) {
            System.out.println("- " + bookName);
        }

    }
}
