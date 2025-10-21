package managers;

import books.Book;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BookInventoryManager {
    private Map<Boolean, HashSet<Book>> bookAvailabilityMap;

    public BookInventoryManager() {
        bookAvailabilityMap = new HashMap<>();
        bookAvailabilityMap.put(true, new HashSet<>());
        bookAvailabilityMap.put(false, new HashSet<>());
    }

    public void addBook(Book book) {
        HashSet<Book> availableBooks = bookAvailabilityMap.get(true);
        availableBooks.add(book);
    }

    public Book getBookById(int bookId) {
        HashSet<Book> availableBooks = bookAvailabilityMap.get(true);
        availableBooks.addAll(bookAvailabilityMap.get(false));
        for (Book book : availableBooks) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public Book getBookByTitle(String bookTitle) {
        HashSet<Book> availableBooks = bookAvailabilityMap.get(true);
        availableBooks.addAll(bookAvailabilityMap.get(false));
        for (Book book : availableBooks) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    public boolean issueBook(Book book) {
        if(book.isAvailable()) {
            book.issueBook();
            bookAvailabilityMap.get(false).add(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if(!book.isAvailable()) {
            book.returnBook();
            bookAvailabilityMap.get(true).add(book);
            return true;
        }
        return false;
    }

    public boolean isBookAvailable(Book book) {
        return book.isAvailable();
    }

    public Set<Book> getAvailableBooks() {
        return bookAvailabilityMap.get(true);
    }

    public Set<Book> getIssuesBooks() {
        return bookAvailabilityMap.get(false);
    }
}
