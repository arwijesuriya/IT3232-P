/*
    implement classes for a Library
    There are diffrent type of books are available in the
    library like Printed books, E books, and Audio books

    You must use inhertance, polymorphism, encapuslation...
*/

abstract class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() { 
        return title; 
    }
    public String getAuthor() { 
        return author; 
    }
    public int getYear() { 
        return year; 
    }

    public abstract void displayDetails();
}

// PrintedBook
class PrintedBook extends Book {
    private int pages;

    public PrintedBook(String title, String author, int year, int pages) {
        super(title, author, year);
        this.pages = pages;
    }

    @Override
    public void displayDetails() {
        System.out.println("Printed Book: " + getTitle() + " by " + getAuthor() + " (" + getYear() + ")");
        System.out.println("Pages: " + pages);
    }
}

// EBook
class EBook extends Book {
    private double fileSize;

    public EBook(String title, String author, int year, double fileSize) {
        super(title, author, year);
        this.fileSize = fileSize;
    }

    @Override
    public void displayDetails() {
        System.out.println("E-Book: " + getTitle() + " by " + getAuthor() + " (" + getYear() + ")");
        System.out.println("File Size: " + fileSize + " MB");
    }
}

// AudioBook
class AudioBook extends Book {
    private double duration;

    public AudioBook(String title, String author, int year, double duration) {
        super(title, author, year);
        this.duration = duration;
    }

    @Override
    public void displayDetails() {
        System.out.println("Audio Book: " + getTitle() + " by " + getAuthor() + " (" + getYear() + ")");
        System.out.println("Duration: " + duration + " hours");
    }
}

public class EC07 {
    public static void main(String[] args) {
        
        Book printedBook = new PrintedBook("Harry Potter and the Philosopher's Stone", "J.K.Rowling", 1997, 223);
        Book eBook = new EBook("Wild Side", "Elsie Silver", 2025, 2.4);
        Book audioBook = new AudioBook("Atomic Habits", "James Clear", 2018, 5.35);

        // Storing books array
        Book[] books = {printedBook, eBook, audioBook};

        // Displaying details
        for (Book book : books) {
            book.displayDetails();
            System.out.println("-------------------------------------");
        }
    }
}
