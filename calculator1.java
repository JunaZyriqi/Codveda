import java.util.Scanner;

class calculator1 {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public String divide(double a, double b) {
        if (b == 0) {
            return "Error: Division by zero";
        }
        return String.valueOf(a / b);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        calculator1 calculator = new calculator1();

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        switch (operation) {
            case '+':
                System.out.println(calculator.add(num1, num2));
                break;

            case '-':
                System.out.println(calculator.subtract(num1, num2));
                break;

            case '*':
                System.out.println(calculator.multiply(num1, num2));
                break;

            case '/':
                System.out.println(calculator.divide(num1, num2));
                break;

            default:
                System.out.println("Invalid operation");
        }

        scanner.close();
    }
}