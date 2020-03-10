import java.util.Scanner;

public class test extends Fraction{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a numerator and a denominator");
        int nume = scan.nextInt();
        int den = scan.nextInt();

        Fraction f = new Fraction(nume, den);

        f.simplify();

        System.out.println(f.getNumerator() + " " + f.getDenominator());
    }
}
