import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileProcessing {

    public static void main(String[] args) {

        int lineCount = 0;
        int wordCount = 0;

        try {
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineCount++;

                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            scanner.close();

            PrintWriter writer = new PrintWriter("output.txt");
            writer.println("Number of lines: " + lineCount);
            writer.println("Number of words: " + wordCount);
            writer.close();

            System.out.println("Processing complete. Results written to output.txt");

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
