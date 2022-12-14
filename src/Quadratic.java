/**
 * @author Justin Lee, AP CSA P1
 */

public class Quadratic {
    // Instance variables
    private int a; // Coefficient "a"; coefficient of the first term.
    private int b; // Coefficient "b"; coefficient of the second term.
    private int c; // Term "c"; the constant
    private int numRoots;

    /**
     * Constructs a Quadratic object that initializes the coefficients and the number of roots.
     * @param a First term's coefficient
     * @param b Second term's coefficient
     * @param c The third term; the constant
     */
    public Quadratic(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;

        // Finds the number of roots based on the discriminant of the quadratic.
        if (discriminant() > 0) {
            numRoots = 2;
        }
        else if (discriminant() == 0) {
            numRoots = 1;
        }
        else { // if the discriminant is < 0
            numRoots = 0;
        }
    }

    /**
     * Returns the value of the first coefficient.
     * @return Coefficient "a"; the first term's coefficient
     */
    public int getCoeffA() {
        return a;
    }

    /**
     * Returns the value of the second coefficient.
     * @return Coefficient "b"; the second term's coefficient
     */
    public int getCoeffB() {
        return b;
    }

    /**
     * Returns the value of the third term.
     * @return Term "c"; the constant
     */
    public int getCoeffC() {
        return c;
    }

    /**
     * Returns how many roots the quadratic has.
     * @return The number of the quadratic's roots.
     */
    public int getNumRoots() {
        return numRoots;
    }

    /**
     * Gets the value of the quadratic's discriminant. Used to find the number of roots and in the quadratic formula.
     * @return The value of the discriminant.
     */
    public int discriminant() {
        return b*b - 4*a*c;
    }

    /**
     * Makes the roots of the polynomial into String form; makes it readable by the user.
     * @return String for the polynomial's roots.
     */
    public String returnString() {
        if (numRoots == 2) { // Returns both of the roots using the positive and negative versions of the quadratic formula.
            return "x = " + quadraticFormulaPos() + ", x = " + quadraticFormulaNeg();
        }
        else if (numRoots == 1) { // Returns the quadratic's single root by using the positive version of the quadratic formula (positive or negative ver. doesn't matter).
            return "x = " + quadraticFormulaPos();
        }
        else { // Returns NO REAL SOLUTIONS if there are no roots.
            return "No real solutions";
        }
    }

    /**
     * Returns the value of a root using the positive version of the Quadratic Formula.
     * @return The double value of the root using the positive version.
     */
    public double quadraticFormulaPos() {
        return (-1*b+Math.sqrt(discriminant()))/(2*a);
    }

    /**
     * Returns the value of a root using the negative version of the Quadratic Formula.
     * @return The double value of the root using the negative version.
     */
    public double quadraticFormulaNeg() {
        return (-1*b-Math.sqrt(discriminant()))/(2*a);
    }

}
