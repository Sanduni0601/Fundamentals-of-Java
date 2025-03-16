abstract class Book {
    private String title;
    private String author;
    private boolean isAvailable;
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    
    public void checkOut() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been checked out.");
        } else {
            System.out.println(title + " is not available.");
        }
    }
    
    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }
    
    public abstract void displayDetails();
}

class PrintedBook extends Book {
    private int pages;
    
    public PrintedBook(String title, String author, int pages) {
        super(title, author);
        this.pages = pages;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Printed Book: " + getTitle() + " by " + getAuthor() + 
                          ", Pages: " + pages + ", Available: " + isAvailable());
    }
}

class EBook extends Book {
    private String format;
    
    public EBook(String title, String author, String format) {
        super(title, author);
        this.format = format;
    }
    
    public void download() {
        System.out.println("Downloading " + getTitle() + " in " + format + " format.");
    }
    
    @Override
    public void displayDetails() {
        System.out.println("E-Book: " + getTitle() + " by " + getAuthor() + 
                          ", Format: " + format + ", Available: " + isAvailable());
    }
}

class AudioBook extends Book {
    private String narrator;
    private double duration;
    
    public AudioBook(String title, String author, String narrator, double duration) {
        super(title, author);
        this.narrator = narrator;
        this.duration = duration;
    }
    
    public void play() {
        System.out.println("Playing " + getTitle() + " narrated by " + narrator);
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Audio Book: " + getTitle() + " by " + getAuthor() + 
                          ", Narrator: " + narrator + ", Duration: " + duration + 
                          " mins, Available: " + isAvailable());
    }
}

class Library {
    private Book[] books;
    private int count;
    
    public Library() {
        books = new Book[10];
        count = 0;
    }
    
    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
            System.out.println(book.getTitle() + " added to library.");
        }
    }
    
    public void displayAllBooks() {
        System.out.println("\n----- LIBRARY CATALOG -----");
        for (int i = 0; i < count; i++) {
            books[i].displayDetails();
        }
    }
}

public class seventh {
    public static void main(String[] args) {
        Library library = new Library();

        PrintedBook book1 = new PrintedBook("The Great Gatsby", "F. Scott Fitzgerald", 180);
        EBook book2 = new EBook("1984", "George Orwell", "PDF");
        AudioBook book3 = new AudioBook("Harry Potter", "J.K. Rowling", "Jim Dale", 480);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayAllBooks();
        System.out.println("\n----- TESTING FUNCTIONALITY -----");
        book1.checkOut();
        book2.download();
        book3.play();
    }
}