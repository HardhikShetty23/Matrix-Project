import java.util.Scanner;

public class Eigenvector2x2_Simplified {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter elements of 2x2 matrix:");
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

        double discriminant = Math.pow(trace, 2) - 4 * determinant;

        if (discriminant < 0) {
            System.out.println("Complex eigenvalues. No real eigenvectors.");
            return;
        }

        double lambda1 = (trace + Math.sqrt(discriminant)) / 2;
        double lambda2 = (trace - Math.sqrt(discriminant)) / 2;

        System.out.printf("Eigenvalues:\nλ1 = %.3f\nλ2 = %.3f\n", lambda1, lambda2);

        System.out.println("\nEigenvectors (in simplified k format):");

        findEigenvector(a, b, c, d, lambda1, "λ1");
        findEigenvector(a, b, c, d, lambda2, "λ2");

        scanner.close();
    }

    private static void findEigenvector(double a, double b, double c, double d, double lambda, String label) {
        double m11 = a - lambda;
        double m22 = d - lambda;

        double x, y;

        if (Math.abs(b) > 1e-6) {
            x = -b;
            y = m11;
        } else if (Math.abs(c) > 1e-6) {
            x = m22;
            y = -c;
        } else {
            x = 1;
            y = 0;
        }

        double ratio = (Math.abs(y) > 1e-6) ? x / y : 0;

        System.out.printf("%s: k(%.3f, 1.000)\n", label, ratio);
    }
}
