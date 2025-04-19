import java.util.Scanner;

public class CharacteristicEquation2x2 {

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
        double det = a * d - b * c;

        System.out.printf("The characteristic equation is:%n");
        System.out.printf("λ² %+,.2fλ %+,.2f = 0%n", -trace, det);
    }
}
