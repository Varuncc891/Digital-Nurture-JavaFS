import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = scanner.nextLine();
        StringBuilder sb = new StringBuilder(str);
        System.out.println("Reversed: " + sb.reverse().toString());
        scanner.close();
    }
}