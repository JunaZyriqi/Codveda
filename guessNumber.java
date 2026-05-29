import java.util.Random;
import java.util.Scanner;

public class guessNumber {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int numberToGuess = random.nextInt(100) + 1;
        int maxAttempts = 5;
        int attempts = 0;

        System.out.println("Guess the number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {

            System.out.print("Enter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            int guess = scanner.nextInt();
            attempts++;

            if (guess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number.");
                break;
            } else if (guess > numberToGuess) {
                System.out.println("Too high.");
            } else {
                System.out.println("Too low.");
            }

            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }

        if (attempts == maxAttempts) {
            System.out.println("Game over! The number was: " + numberToGuess);
        }

        scanner.close();
    }
}
