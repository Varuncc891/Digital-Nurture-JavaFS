import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        try (FileWriter fw = new FileWriter("output.txt")) {
            fw.write(text);
            System.out.println("Written to output.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}