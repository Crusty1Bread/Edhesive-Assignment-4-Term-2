public class Fraction {
    private int numerator;
    private int denominator;

    // Default constructor: creates fraction 1/1
    public Fraction() {
        numerator = 1;
        denominator = 1;
        simplify();
    }

    // Constructor for fraction n/d where n, d > 0
    public Fraction(int n, int d) {
        this();
        if (n > 0) {
            numerator = n;
        }
        if (d > 0) {
            denominator = d;
        }

        simplify();
    }

    // Return the fraction as a String e.g. "2/3"
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Return the fraction as a mixed number String
    public String mixedNumber() {
        // If fraction is proper return fraction using toString method
        if (numerator < denominator) {
            return toString();
        }

        // If numerator is a multiple of denominator return just integer part
        if (numerator % denominator == 0) {
            return "" + numerator/denominator;
        }

        // Otherwise return mixed number string
        return numerator/denominator + " " + numerator%denominator + "/" + denominator;
    }

    // Adds the fraction n/d to this fraction if n and d are both greater than 0
    public void add(int n, int d) {
        if(n > 0 && d > 0) {
            numerator = numerator * d + n * denominator;
            denominator *= d;
        }

        simplify();
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return  numerator;
    }

    public int compareTo(Object object2) {
        Fraction fraction2 = (Fraction)object2;

        double fractionA = (double)getNumerator() / getDenominator();
        double fractionB = (double)fraction2.getNumerator() / fraction2.getDenominator();

        if (fractionA < fractionB) {
            return -1;
        } else if (fractionA > fractionB) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int gcd(int a, int b) {
        int gcd = 0;
        if (a >= b) {
            for (int i = 1; i <= b; i++ ) {
                if ((a % i == 0) && (b % i ==0)) {
                    gcd = i;
                }
            }
        } else {
            for (int i = 1; i <= a; i++) {
                if ((a % i == 0) && (b % i == 0)) {
                    gcd = i;
                }
            }
        }

        return gcd;
    }

    public void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }

}