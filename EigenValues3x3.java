import java.util.Scanner;

public class MatrixEigenvaluesSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the elements of the 3x3 matrix:");

        System.out.print("a: ");
        double a11 = scanner.nextDouble();
        System.out.print("b: ");
        double a12 = scanner.nextDouble();
        System.out.print("c: ");
        double a13 = scanner.nextDouble();
        System.out.print("d: ");
        double a21 = scanner.nextDouble();
        System.out.print("e: ");
        double a22 = scanner.nextDouble();
        System.out.print("f: ");
        double a23 = scanner.nextDouble();
        System.out.print("g: ");
        double a31 = scanner.nextDouble();
        System.out.print("h: ");
        double a32 = scanner.nextDouble();
        System.out.print("i: ");
        double a33 = scanner.nextDouble();

        double P = a11 + a22 + a33;
        double Q = (a22 * a33 - a23 * a32) + (a11 * a33 - a13 * a31) + (a11 * a22 - a12 * a21);
        double detA = a11 * (a22 * a33 - a23 * a32) - a12 * (a21 * a33 - a23 * a31) + a13 * (a21 * a32 - a22 * a31);

        double b = -P;
        double c = Q;
        double d = -detA;

        double[] eigenvalues = solveCubic(1, b, c, d);

        System.out.println("\nEigenvalues:");
        for (double eigenvalue : eigenvalues) {
            System.out.printf("%.6f\n", eigenvalue);
        }

        scanner.close();
    }

    private static double[] solveCubic(double a, double b, double c, double d) {
        double[] roots = new double[3];
        double root1 = newtonMethod(a, b, c, d, 1.0);
        roots[0] = root1;
        double[] quadraticCoefficients = cubicToQuadratic(a, b, c, d, root1);
        double[] quadraticRoots = solveQuadratic(quadraticCoefficients[0], quadraticCoefficients[1], quadraticCoefficients[2]);
        roots[1] = quadraticRoots[0];
        roots[2] = quadraticRoots[1];
        return roots;
    }

    private static double newtonMethod(double a, double b, double c, double d, double guess) {
        double tolerance = 1e-6;
        int maxIterations = 1000;
        double lambda = guess;

        for (int i = 0; i < maxIterations; i++) {
            double f = a * Math.pow(lambda, 3) + b * Math.pow(lambda, 2) + c * lambda + d;
            double fPrime = 3 * a * Math.pow(lambda, 2) + 2 * b * lambda + c;

            if (Math.abs(f) < tolerance) {
                return lambda;
            }

            lambda = lambda - f / fPrime;
        }

        return lambda;
    }

    private static double[] cubicToQuadratic(double a, double b, double c, double d, double root) {
        double A = a;
        double B = b + A * root;
        double C = c + B * root;
        return new double[]{A, B, C};
    }

    private static double[] solveQuadratic(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        return new double[]{root1, root2};
    }
}
