import java.util.Scanner;

public class factorialRecursive {

    // recursive method to calculate factorial
    public static long factorial(int n) {

        if (n < 0) {
            return -1; // used to indicate invalid input
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        long result = factorial(number);

        if (result == -1) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            System.out.println("Factorial of " + number + " is: " + result);
        }

        scanner.close();
    }
}