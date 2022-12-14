/**
 * @author Justin Lee, AP CSA P1
 */

import java.util.Scanner;

public class QuadraticRootsCalc {
    public static void main(String[] args) {

        // Gets input from the user in a while(true) loop; the quadratic expression can be entered any number of times without rerun.
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("What is your quadratic expression (ax^2 + bx + c)? Enter \"quit\" to exit and enter \"help\" for formatting/input help.");
            String expression = in.nextLine();

            // If the entered input is "quit", the program closes.
            if (expression.equals("quit")) {
                break;
            }

            // If the entered input is "help", the program prints out a text for formatting help.
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

            // Prints out the quadratic's roots using produceAnswer.
            System.out.println(produceAnswer(expression));
            System.out.println();
        }
    }

    /**
     * A method that produces an answer (a String for the # of roots and the root(s)'s value(s)) using the Quadratic class.
     * @param input The raw user input
     * @return The String containing the number of roots and their values OR an error message.
     */
    public static String produceAnswer(String input) {
        // Splits the input up with a delimiter for " ", which splits up the terms and the operators.
        Scanner expression = new Scanner(input);
        expression.useDelimiter(" ");

        // Since the code would be repeated when finding the coefficients for the 1st and 2nd term, a loop goes through the Scanner and saves the coefficients' values through an array.
        int[] coefficients = {1, 1, 1}; // Arrays to save the values for the coefficients and operators.
        String[] operators = {"+", "+"};
        String currentOperator = "";

        // Getting the first and second coefficient
        for (int k = 0; k < 2; k++) { // Loops through 2 times to capture the 1st and 2nd terms and operators.
            if (!expression.hasNext()){ // ERROR CHECK: If there isn't an input, returns an error message.
                return "ERROR: Input is in an invalid format.";
            }

            // Initializes temporary variables for the coefficient and term.
            String coeff = "";
            String term = expression.next();

            // Uses a loop to get the coefficient as a string.
            int i;
            for (i = 0; i < term.length(); i++) { // Adds everything before the "x" to the coefficient String.
                if (term.charAt(i) == 'x') {
                    break;
                }
                coeff += term.charAt(i);
            }

            // Tests for each case of coefficient to save a coefficient value in the array.
            if (i == 0) { // Checks to see if there is no coefficient; initializes to 1
                coefficients[k] = 1;
            }
            else if (coeff.equals("-")) { // Checks to see if there is no numeric value in the coefficient but has a negative; initializes to -1
                coefficients[k] = -1;
            }
            else { // Getting the value of the coefficient
                coefficients[k] = Integer.parseInt(coeff);
            }

            // Getting the operator between the terms
            currentOperator = expression.next();
            if (!currentOperator.equals("+") && !currentOperator.equals("-")) { // ERROR CHECK: If the operator isn't addition or subtraction, returns an error message.
                return "ERROR: Input is in an invalid format.";
            }
            else { // Saves the value of the operator.
                operators[k] = currentOperator;
            }
        }

        // Getting the third term
        if (!expression.hasNext()){ // ERROR CHECK: If there isn't an input for the third term, returns an error message.
            return "ERROR: Input is in an invalid format.";
        }
        coefficients[2] = Integer.parseInt(expression.next());

        // Factoring in the operators
        for (int i = 0; i < 2; i++) { // Loops through the operators array and makes the coefficient negative if the operator is subtraction.
            if (operators[i].equals("-")) {
                coefficients[i+1] *= -1;
            }
        }

        // Calculating the roots using a Quadratic object.
        Quadratic quad = new Quadratic(coefficients[0], coefficients[1], coefficients[2]);
        return "Number of solutions: " + quad.getNumRoots() + "\n" + quad.returnString();
    }
}
