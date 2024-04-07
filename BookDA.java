import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class BookDA {

    private HashMap<String, Book> bookMap;

    public BookDA() {
        bookMap = new HashMap<>();
        readBooksFromFile();
    }

    private void readBooksFromFile() {
        try {
            Scanner inputFile = new Scanner(new FileReader("C:\\JavaProject\\LabSW5_HashMap_Exercise\\src\\Book.csv"));
            inputFile.nextLine(); 
            while (inputFile.hasNextLine()) {
                String lineData = inputFile.nextLine();
                String[] splitData = lineData.split(",");
                String isbn = splitData[0].trim();
                String title = splitData[1].trim();
                String authorName = splitData[2].trim();

                AuthorDA authorDA = new AuthorDA();
                Author author = authorDA.getAuthorHashMap().get(authorName);
                if (author != null) {
                    Book book = new Book(isbn, title, author);
                    bookMap.put(isbn, book);
                } else {
                    System.out.println("Author not found for book with ISBN: " + isbn);
                }
            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading book data: " + e.getMessage());
        }
    }

    public HashMap<String, Book> getBookMap() {
        return bookMap;
    }
}
