import java.util.Scanner;

public class CharacteristicEquationSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the coefficients of the characteristic equation:");
        System.out.print("Enter coefficient a (for λ^3): ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b (for λ^2): ");
        double b = scanner.nextDouble();
        System.out.print("Enter coefficient c (for λ): ");
        double c = scanner.nextDouble();
        System.out.print("Enter coefficient d (constant term): ");
        double d = scanner.nextDouble();

        double[] eigenvalues = solveCubic(a, b, c, d);

        System.out.println("Eigenvalues (roots of the characteristic equation): ");
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
        double maxIterations = 1000;
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
        double D = d + C * root;


        return new double[]{A, B, C};
    }


    private static double[] solveQuadratic(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

        return new double[]{root1, root2};
    }
}
