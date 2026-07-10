import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int target = random.nextInt(100) + 1;
        int guess = 0;
        System.out.println("Guess a number between 1 and 100:");
        while (guess != target) {
            guess = scanner.nextInt();
            if (guess > target) {
                System.out.println("Too high!");
            } else if (guess < target) {
                System.out.println("Too low!");
            }
        }
        System.out.println("Correct!");
        scanner.close();
    }
}