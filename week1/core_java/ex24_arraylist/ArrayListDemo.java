import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        System.out.println("Enter name (or 'exit' to quit):");
        while (true) {
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) break;
            names.add(input);
        }
        for (String name : names) {
            System.out.println(name);
        }
        scanner.close();
    }
}