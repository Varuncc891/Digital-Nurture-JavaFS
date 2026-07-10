import java.util.Scanner;

public class ArraySumAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        int sum = 0;
        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        double avg = (double) sum / size;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
        scanner.close();
    }
}