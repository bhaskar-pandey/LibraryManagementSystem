package books;

public class Book {

    private int book_id;
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private boolean isAvailable;

    public Book(int book_id, String title, String author, String isbn, int publicationYear) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
    }

    public int getBookId() {
        return book_id;
    }

    public  String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void issueBook() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }
}

