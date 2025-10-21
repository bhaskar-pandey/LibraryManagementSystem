package managers;

import books.Book;
import patrons.Patron;

import java.util.*;

public class BookIssueManager {

    private Map<Patron, Map<Long,Map<Boolean, Set<String>>>> bookIssueMap;
    private BookInventoryManager bookInventoryManager;

    public BookIssueManager(BookInventoryManager bookInventoryManager) {
        this.bookIssueMap = new HashMap<>();
        this.bookInventoryManager = bookInventoryManager;
    }

    public boolean issueBookToPatron(Book book, Patron patron) {
        if(bookInventoryManager.isBookAvailable(book)) {
            bookInventoryManager.issueBook(book);
            bookIssueMap.putIfAbsent(patron, new HashMap<>());
            long issueDate = System.currentTimeMillis();
            bookIssueMap.get(patron).putIfAbsent(issueDate, new HashMap<>());
            bookIssueMap.get(patron).get(issueDate).putIfAbsent(true, new HashSet<>());
            bookIssueMap.get(patron).get(issueDate).get(true).add(book.getTitle());
            return true;
        }
        return false;
    }

    public boolean returnBookFromPatron(Book book, Patron patron) {
        if(bookIssueMap.containsKey(patron)) {
            long returnDate = System.currentTimeMillis();
            bookIssueMap.get(patron).putIfAbsent(returnDate, new HashMap<>());
            bookIssueMap.get(patron).get(returnDate).putIfAbsent(false, new HashSet<>());
            bookIssueMap.get(patron).get(returnDate).get(false).add(book.getTitle());
            bookInventoryManager.returnBook(book);
            return true;
        }
        return false;
    }

    public Set<String> getBooksIssuedToPatron(Patron patron) {
        Set<String> issuedBooks = new HashSet<>();
        if(bookIssueMap.containsKey(patron)) {
            Map<Long, Map<Boolean, Set<String>>> dateMap = bookIssueMap.get(patron);
            for(Map<Boolean, Set<String>> statusMap : dateMap.values()) {
                if(statusMap.containsKey(true)) {
                    issuedBooks.addAll(statusMap.get(true));
                }
                if(statusMap.containsKey(false)) {
                    issuedBooks.removeAll(statusMap.get(false));
                }
            }
        }
        return issuedBooks;
    }

    public Map<Long, Map<Boolean, Set<String>>> getBookIssueHistoryForPatron(Patron patron) {
        return bookIssueMap.getOrDefault(patron, new HashMap<>());
    }
}
