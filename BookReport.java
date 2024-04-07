import java.util.HashMap;

public class BookReport {
    public static void main(String[] args) {
        BookDA bookDA = new BookDA();

        HashMap<String, Book> bookMap = bookDA.getBookMap();

        for (HashMap.Entry<String, Book> entry : bookMap.entrySet()) {
            String isbn = entry.getKey();
            Book book = entry.getValue();

            System.out.println(isbn + " " + book.getTitle());

            Author author = book.getAuthor();
            if (author != null) {
                System.out.println("\t" + author.getName() + " - " + author.getBio());
            } else {
                System.out.println("\tAuthor information missing");
            }
        }
    }
}
