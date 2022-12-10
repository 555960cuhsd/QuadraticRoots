import java.util.Scanner;

public class QuadraticRootsCalc {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("What is your quadratic expression (ax^2 + bx + c)? Enter \"quit\" to exit and enter \"help\" for formatting/input help.");
            String expression = in.nextLine();
            if (expression.equals("quit")) {
                break;
            }
            if (expression.equals("help")) {
                System.out.println("************************************************* FORMATTING HELP *************************************************");
                System.out.println("Your input should be a quadratic trinomial expression in the form of \"ax^2 + bx + c\".");
                System.out.println("The a, b, and c parts of the expressions are the corresponding coefficients for each term.");
                System.out.println("For negative coefficients, change the addition sign to a subtraction sign.");
                System.out.println("");

                System.out.println("EXAMPLE INPUT: \"-5x^2 + x - 5\"");
                System.out.println("********************************************************************************************************************");
                System.out.println("");
                continue;
            }
            System.out.println(produceAnswer(expression));
            System.out.println();
        }
    }

    public static String produceAnswer(String input) {
        Scanner expression = new Scanner(input);
        expression.useDelimiter(" ");

        int[] coefficients = {1, 1, 1};
        String[] operators = {"+", "+"};
        String currentOperator = "";

        // Getting the first and second coefficient
        for (int k = 0; k < 2; k++) {
            if (!expression.hasNext()){
                return "ERROR: Input is in an invalid format.";
            }

            String coeff = "";
            String term = expression.next();

            // Uses a loop to get the coefficient as a string
            int i;
            for (i = 0; i < term.length(); i++) {
                if (term.charAt(i) == 'x') {
                    break;
                }
                coeff += term.charAt(i);
            }
            //System.out.println("Coefficient string for number " + (k+1) + ": " + coeff);
            // Checks to see if there is no coefficient; initializes to 1
            if (i == 0) {
                coefficients[k] = 1;
            }
            // Checks to see if there is no numeric value in the coefficient but has a negative; initializes to -1
            else if (coeff.equals("-")) {
                coefficients[k] = -1;
            }
            // Getting the value of the coefficient
            else {
                coefficients[k] = Integer.parseInt(coeff);
            }

            //System.out.println("BEFORE CHANGING The operator for number " + (k+1) + ": " + operators[k]);
            //System.out.println("expression.next: " + currentOperator);

            // Getting the operator between the terms
            currentOperator = expression.next();
            if (!currentOperator.equals("+") && !currentOperator.equals("-")) {
                return "ERROR: Input is in an invalid format.";
            }
            else {
                operators[k] = currentOperator;
            }
            //System.out.println("The operator for number " + (k+1) + ": " + operators[k]);

        }

        // Getting the third term
        if (!expression.hasNext()){
            return "ERROR: Input is in an invalid format.";
        }
        coefficients[2] = Integer.parseInt(expression.next());

        // Factoring in the operators
        for (int i = 0; i < 2; i++) {
            if (operators[i].equals("-")) {
                coefficients[i+1] *= -1;
            }
        }

        // Calculating the roots
        //System.out.println("First coeff: " + coefficients[0]);
        //System.out.println("Second coeff: " + coefficients[1]);
        //System.out.println("Third coeff: " + coefficients[2]);

        Quadratic quad = new Quadratic(coefficients[0], coefficients[1], coefficients[2]);
        return "Number of solutions: " + quad.getNumRoots() + "\n" + quad.returnString();
    }
}
