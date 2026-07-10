import java.util.HashMap;
import java.util.Scanner;

public class HashMapDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> map = new HashMap<>();
        System.out.println("Enter entries (ID name, '0 exit' to finish):");
        while (true) {
            int id = scanner.nextInt();
            String name = scanner.next();
            if (id == 0) break;
            map.put(id, name);
        }
        System.out.print("Enter ID to search: ");
        int searchId = scanner.nextInt();
        System.out.println("Name: " + map.getOrDefault(searchId, "Not Found"));
        scanner.close();
    }
}