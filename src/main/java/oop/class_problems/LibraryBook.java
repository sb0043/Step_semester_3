package oop.class_problems;

public class LibraryBook {

    String title;
    String isbn;

    public LibraryBook(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public LibraryBook(String title) {
        this(title, "PENDING");
    }

    public static void main(String[] args) {

        LibraryBook book1 =
                new LibraryBook("Clean Code", "978-0132350884");

        LibraryBook book2 =
                new LibraryBook("Untitled Draft");

        LibraryBook book3 =
                new LibraryBook("1984", "9780451524935");

        LibraryBook book4 =
                new LibraryBook("Notes");

        System.out.println(book1.title + " | " + book1.isbn + " | Catalogued: true");
        System.out.println(book2.title + " | " + book2.isbn + " | Catalogued: true");
        System.out.println(book3.title + " | " + book3.isbn + " | Catalogued: true");
        System.out.println(book4.title + " | " + book4.isbn + " | Catalogued: true");
    }
}