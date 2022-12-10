public class Quadratic {
    private int a;
    private int b;
    private int c;
    private int numRoots;

    public Quadratic(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;

        if (discriminant() > 0) {
            numRoots = 2;
        }
        else if (discriminant() == 0) {
            numRoots = 1;
        }
        else {
            numRoots = 0;
        }
    }

    public int getCoeffA() {
        return a;
    }

    public int getCoeffB() {
        return b;
    }

    public int getCoeffC() {
        return c;
    }

    public int getNumRoots() {
        return numRoots;
    }

    public int discriminant() {
        return b*b - 4*a*c;
    }

    public String returnString() {
        if (numRoots == 2) {
            return "x = " + quadraticFormulaPos() + ", x = " + quadraticFormulaNeg();
        }
        else if (numRoots == 1) {
            return "x = " + quadraticFormulaPos();
        }
        else {
            return "No real solutions";
        }
    }

    public double quadraticFormulaPos() {
        return (-1*b+Math.sqrt(discriminant()))/(2*a);
    }

    public double quadraticFormulaNeg() {
        return (-1*b-Math.sqrt(discriminant()))/(2*a);
    }

}
