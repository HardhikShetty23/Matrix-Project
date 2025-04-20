import java.util.Scanner;

public class MatrixCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Matrix Calculator ===");
            System.out.println("1. 2x2 Matrix Operations");
            System.out.println("2. 3x3 Matrix Operations");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int matrixChoice = scanner.nextInt();

            if (matrixChoice == 0) {
                System.out.println("Exiting Matrix Calculator. Goodbye!");
                break;
            }

            if (matrixChoice == 1) {
                System.out.println("--- 2x2 Matrix Operations ---");
                System.out.println("1. Find Characteristic Equation");
                System.out.println("2. Find Eigenvalues");
                System.out.println("3. Find Eigenvectors");
                System.out.print("Choose an option: ");
                int op2x2 = scanner.nextInt();

                switch (op2x2) {
                    case 1:
                        CharacteristicEquation2x2.main(null);
                        break;
                    case 2:
                        EigenValues2x2.main(null);
                        break;
                    case 3:
                        EigenVectors2x2.main(null);
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } else if (matrixChoice == 2) {
                System.out.println("--- 3x3 Matrix Operations ---");
                System.out.println("1. Find Characteristic Equation");
                System.out.println("2. Find Eigenvalues");
                System.out.println("3. Find Eigenvectors");
                System.out.print("Choose an option: ");
                int op3x3 = scanner.nextInt();

                switch (op3x3) {
                    case 1:
                        CharacteristicEquation3x3.main(null);
                        break;
                    case 2:
                        EigenValues3x3.main(null);
                        break;
                    case 3:
                        EigenVectors3x3.main(null);
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } else {
                System.out.println("Invalid matrix type.");
            }
            System.out.println();
        }
        scanner.close();
    }
}
