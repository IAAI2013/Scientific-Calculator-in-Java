import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Scientific Calculator ===");

            boolean running = true;
            while (running) {
                System.out.println();
                System.out.println("Choose an operation:");
                System.out.println("1. Basic arithmetic (+, -, *, /)");
                System.out.println("2. Scientific functions (sin, cos, tan, sqrt, log, ln, exp, x^y)");
                System.out.println("3. Power / square / cube");
                System.out.println("0. Exit");
                System.out.print("Your choice: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid choice. Please enter a number.");
                    scanner.next();
                    continue;
                }

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        performBasicCalculation(scanner);
                        break;
                    case 2:
                        performScientificCalculation(scanner);
                        break;
                    case 3:
                        performPowerFunctions(scanner);
                        break;
                    case 0:
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
    }

    private static void performBasicCalculation(Scanner scanner) {
        double num1 = readDouble(scanner, "Enter the first number: ");
        System.out.print("Enter the operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        double num2 = readDouble(scanner, "Enter the second number: ");

        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is undefined.");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("Error: Invalid operator.");
                return;
        }

        System.out.printf("Result: %.2f %c %.2f = %.2f%n", num1, operator, num2, result);
    }

    private static void performScientificCalculation(Scanner scanner) {
        System.out.println("Scientific functions available:");
        System.out.println("sin, cos, tan, sqrt, log, ln, exp");
        System.out.print("Enter a function name: ");
        String function = scanner.next().toLowerCase();
        double value = readDouble(scanner, "Enter the value: ");

        double result;
        switch (function) {
            case "sin":
                result = Math.sin(Math.toRadians(value));
                break;
            case "cos":
                result = Math.cos(Math.toRadians(value));
                break;
            case "tan":
                result = Math.tan(Math.toRadians(value));
                break;
            case "sqrt":
                if (value < 0) {
                    System.out.println("Error: Square root is undefined for negative numbers.");
                    return;
                }
                result = Math.sqrt(value);
                break;
            case "log":
                if (value <= 0) {
                    System.out.println("Error: log is undefined for values <= 0.");
                    return;
                }
                result = Math.log10(value);
                break;
            case "ln":
                if (value <= 0) {
                    System.out.println("Error: ln is undefined for values <= 0.");
                    return;
                }
                result = Math.log(value);
                break;
            case "exp":
                result = Math.exp(value);
                break;
            default:
                System.out.println("Error: Invalid scientific function.");
                return;
        }

        System.out.printf("Result: %s(%.2f) = %.4f%n", function, value, result);
    }

    private static void performPowerFunctions(Scanner scanner) {
        System.out.println("Power options:");
        System.out.println("1. x^y");
        System.out.println("2. x^2");
        System.out.println("3. x^3");
        System.out.print("Choose an option: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            return;
        }

        int option = scanner.nextInt();
        double result;

        switch (option) {
            case 1:
                double base = readDouble(scanner, "Enter the base: ");
                double exponent = readDouble(scanner, "Enter the exponent: ");
                result = Math.pow(base, exponent);
                System.out.printf("Result: %.2f ^ %.2f = %.4f%n", base, exponent, result);
                break;
            case 2:
                double squareBase = readDouble(scanner, "Enter the number: ");
                result = Math.pow(squareBase, 2);
                System.out.printf("Result: %.2f^2 = %.4f%n", squareBase, result);
                break;
            case 3:
                double cubeBase = readDouble(scanner, "Enter the number: ");
                result = Math.pow(cubeBase, 3);
                System.out.printf("Result: %.2f^3 = %.4f%n", cubeBase, result);
                break;
            default:
                System.out.println("Error: Invalid option.");
                break;
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            System.out.print(prompt);
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
