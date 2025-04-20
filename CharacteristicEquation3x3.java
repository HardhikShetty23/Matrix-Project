import java.util.Scanner;

public class CharacteristicEquation3x3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the elements of the 3x3 matrix:");
        
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();
        System.out.print("c: ");
        double c = scanner.nextDouble();
        System.out.print("d: ");
        double d = scanner.nextDouble();
        System.out.print("e: ");
        double e = scanner.nextDouble();
        System.out.print("f: ");
        double f = scanner.nextDouble();
        System.out.print("g: ");
        double g = scanner.nextDouble();
        System.out.print("h: ");
        double h = scanner.nextDouble();
        System.out.print("i: ");
        double i = scanner.nextDouble();

        double P = a + e + i;
        double Q = (e * i - f * h) + (a * i - c * g) + (a * e - b * d);
        double detA = a * (e * i - f * h) - b * (d * i - f * g) + c * (d * h - e * g);

        System.out.printf("The characteristic equation is:%n");
        System.out.printf("(LLL) %+,.2f(LL) %+,.2f(L) %+,.2f = 0%n", -P, Q, -detA);
    }
}
