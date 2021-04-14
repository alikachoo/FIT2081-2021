package edu.monash.fit2081.googlebooks;

public class Book {
    private String bookTitle;
    private String bookAuthor;
    private String bookYear;

    public Book(String bookTitle, String bookAuthor, String bookYear) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookYear() {
        return bookYear;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookYear(String bookYear) {
        this.bookYear = bookYear;
    }
}
