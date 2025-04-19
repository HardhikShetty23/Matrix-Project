import java.util.Scanner;

public class EigenVector3x3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matrix = new double[3][3];

        System.out.println("Enter the 3x3 matrix elements:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        double[] eigenvalues = computeEigenvalues(matrix);

        for (double eigenvalue : eigenvalues) {
            double[] eigenvector = gaussianElimination(matrix, eigenvalue);
            System.out.printf("Eigenvector for λ = %.4f: (%.2fk, %.2fk, %.2fk)\n",
                    eigenvalue, eigenvector[0], eigenvector[1], eigenvector[2]);
        }

        scanner.close();
    }

    private static double[] computeEigenvalues(double[][] A) {
        double a = -1;
        double b = A[0][0] + A[1][1] + A[2][2];
        double c = -(A[0][0] * A[1][1] + A[0][0] * A[2][2] + A[1][1] * A[2][2]
                      - A[0][1] * A[1][0] - A[0][2] * A[2][0] - A[1][2] * A[2][1]);
        double d = A[0][0] * (A[1][1] * A[2][2] - A[1][2] * A[2][1])
                 - A[0][1] * (A[1][0] * A[2][2] - A[1][2] * A[2][0])
                 + A[0][2] * (A[1][0] * A[2][1] - A[1][1] * A[2][0]);

        return solveCubic(a, b, c, d);
    }

    private static double[] solveCubic(double a, double b, double c, double d) {
        double[] roots = new double[3];

        double f = ((3 * c / a) - (b * b / (a * a))) / 3;
        double g = ((2 * b * b * b / (a * a * a)) - (9 * b * c / (a * a)) + (27 * d / a)) / 27;
        double h = (g * g / 4) + (f * f * f / 27);

        if (h > 0) {
            double r = -(g / 2) + Math.sqrt(h);
            double s = Math.cbrt(r);
            double t = -(g / 2) - Math.sqrt(h);
            double u = Math.cbrt(t);
            roots[0] = (s + u) - (b / (3 * a));
            roots[1] = Double.NaN;
            roots[2] = Double.NaN;
        } else {
            double i = Math.sqrt((g * g / 4) - h);
            double j = Math.cbrt(i);
            double k = Math.acos(-(g / (2 * i)));
            double m = Math.cos(k / 3);
            double n = Math.sqrt(3) * Math.sin(k / 3);
            double p = -(b / (3 * a));
            roots[0] = 2 * j * m + p;
            roots[1] = -j * (m + n) + p;
            roots[2] = -j * (m - n) + p;
        }
        return roots;
    }

    private static double[] gaussianElimination(double[][] A, double lambda) {
        double[][] m = new double[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                m[i][j] = (i == j) ? A[i][j] - lambda : A[i][j];

        double[] result = new double[3];
        boolean[] freeVariable = new boolean[3];

        if (Math.abs(m[0][0]) < 1e-8 && Math.abs(m[1][0]) > 1e-8)
            swapRows(m, 0, 1);
        if (Math.abs(m[0][0]) < 1e-8 && Math.abs(m[2][0]) > 1e-8)
            swapRows(m, 0, 2);

        if (Math.abs(m[0][0]) > 1e-8) {
            double factor = m[1][0] / m[0][0];
            for (int j = 0; j < 3; j++) m[1][j] -= factor * m[0][j];
            factor = m[2][0] / m[0][0];
            for (int j = 0; j < 3; j++) m[2][j] -= factor * m[0][j];
        }

        if (Math.abs(m[1][1]) > 1e-8) {
            double factor = m[2][1] / m[1][1];
            for (int j = 0; j < 3; j++) m[2][j] -= factor * m[1][j];
        }

        for (int i = 0; i < 3; i++) {
            if (Math.abs(m[i][0]) < 1e-8 && Math.abs(m[i][1]) < 1e-8 && Math.abs(m[i][2]) < 1e-8)
                freeVariable[i] = true;
        }

        result[0] = result[1] = result[2] = 0;
        if (freeVariable[2]) result[2] = 1;
        else if (Math.abs(m[2][2]) > 1e-8) result[2] = 0;

        if (freeVariable[1]) result[1] = 1;
        else if (Math.abs(m[1][1]) > 1e-8) result[1] = (-m[1][2] * result[2]) / m[1][1];

        if (freeVariable[0]) result[0] = 1;
        else if (Math.abs(m[0][0]) > 1e-8)
            result[0] = (-m[0][1] * result[1] - m[0][2] * result[2]) / m[0][0];

        return result;
    }

    private static void swapRows(double[][] matrix, int row1, int row2) {
        for (int j = 0; j < 3; j++) {
            double temp = matrix[row1][j];
            matrix[row1][j] = matrix[row2][j];
            matrix[row2][j] = temp;
        }
    }
}
