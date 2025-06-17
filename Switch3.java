import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Switch3{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean continueCalc = true;

        while (continueCalc) {
            try {
                System.out.print("Enter the number of operations you want to perform: ");
                int n = s.nextInt();
                if (n <= 0) {
                    System.out.println("Please enter a number greater than 0.");
                    continue;
                }

                System.out.print("Enter the first number: ");
                double result = s.nextDouble();

                LinkedList<Double> numbers = new LinkedList<>();
                numbers.add(result); // Add the first number

                for (int i = 1; i <= n; i++) {
                    System.out.print("Enter operator (+, -, *, /, %): ");
                    String operator = s.next();

                    if (!operator.matches("[+\\-*/%]")) {
                        System.out.println("Invalid operator. Please enter one of +, -, *, /, %.");
                        i--; // Repeat this iteration
                        continue;
                    }

                    System.out.print("Enter the next number: ");
                    double number = s.nextDouble();

                    // Check for division or modulo by zero
                    if ((operator.equals("/") || operator.equals("%")) && number == 0) {
                        System.out.println("Cannot divide or modulo by zero.");
                        i--; 
                        continue;
                    }

                    numbers.add(number); 

                    switch (operator) {
                        case "+":
                            result += number;
                            break;
                        case "-":
                            result -= number;
                            break;
                        case "*":
                            result *= number;
                            break;
                        case "/":
                            result /= number;
                            break;
                        case "%":
                            result %= number;
                            break;
                    }

                    System.out.println("Intermediate result after operation " + i + ": " + result);
                }

                System.out.println("The final result is: " + result);
                System.out.println("Numbers entered: " + numbers);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values.");
                s.nextLine(); // Clear the invalid input
            } catch (ArithmeticException e) {
                System.out.println("Arithmetic error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String ch = s.next();
            if (!ch.equalsIgnoreCase("yes")) {
                continueCalc = false;
                System.out.println("Calculator exited.");
            }
        }

        s.close();
    }
}
