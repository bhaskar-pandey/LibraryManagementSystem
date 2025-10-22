package Library;

import books.Book;
import managers.BookInventoryManager;
import managers.BookIssueManager;
import patrons.Patron;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public class Library {

    private String libraryName;
    private String address;
    private String phoneNumber;

    private BookInventoryManager bookInventoryManager;
    private BookIssueManager bookIssueManager;

    public Library(String libraryName, String address, String phoneNumber) {
        this.libraryName = libraryName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.bookInventoryManager = new BookInventoryManager();
        this.bookIssueManager = new BookIssueManager(bookInventoryManager);
    }

    public Patron enrollPatron(int patronId, String patronName, String phoneNumber, String email) {
        return new Patron(patronId, patronName, phoneNumber, email);
    }

    public Book addBookToInventory(int bookId, String title, String author, String isbn, int publicationYear) {
        Book book = new Book(bookId, title, author, isbn, publicationYear);
        bookInventoryManager.addBook(book);
        return book;
    }

    public boolean issueBookToPatron(Book book, Patron patron) {
        return bookIssueManager.issueBookToPatron(book, patron);
    }

    public boolean returnBookFromPatron(Book book, Patron patron) {
        return bookIssueManager.returnBookFromPatron(book, patron);
    }

    public Set<String> getBooksIssuedToPatron(Patron patron) {
        return bookIssueManager.getBooksIssuedToPatron(patron);
    }

    public Map<Long, Map<Boolean, Set<String>>> getBookIssueHistoryForPatron(Patron patron) {
        return bookIssueManager.getBookIssueHistoryForPatron(patron);
    }
}
