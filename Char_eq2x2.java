import java.util.Scanner;

public class CharacteristicEquation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the elements of the 2x2 matrix:");
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();
        System.out.print("c: ");
        double c = scanner.nextDouble();
        System.out.print("d: ");
        double d = scanner.nextDouble();

        double trace = a + d;
        double determinant = (a * d) - (b * c);

        System.out.println("The characteristic equation is:");
        System.out.println("(LL) - " + trace + "(L) + " + determinant + " = 0");
    }
}
