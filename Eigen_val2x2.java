import java.util.Scanner;

public class Eigenvalues2x2 {

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
        double determinant = a * d - b * c;

        double discriminant = trace * trace - 4 * determinant;
        
        if (discriminant >= 0) {
            double lambda1 = (trace + Math.sqrt(discriminant)) / 2;
            double lambda2 = (trace - Math.sqrt(discriminant)) / 2;

            System.out.printf("The eigenvalues are: %.2f and %.2f%n", lambda1, lambda2);
        } else {
            System.out.println("The matrix has complex eigenvalues.");
        }
    }
}
