import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class AuthorDA {
    private HashMap<String, Author> authorHashMap;

    public AuthorDA() {
        authorHashMap = new HashMap<>();
        readAuthorsFromFile();
    }
    private void readAuthorsFromFile() {
        try {
            Scanner inputFile = new Scanner(new FileReader("C:\\JavaProject\\LabSW5_HashMap_Exercise\\src\\Author.csv"));
            while (inputFile.hasNextLine()) {
                String lineData = inputFile.nextLine();
                String[] splitData = lineData.split(",");
                String name = splitData[0].trim();
                String bio = splitData[1].trim();

                Author author = new Author(name, bio);
                authorHashMap.put(name, author);
            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading author data: " + e.getMessage());
        }
    }

    public HashMap<String, Author> getAuthorHashMap() {
        return authorHashMap;
    }
}
