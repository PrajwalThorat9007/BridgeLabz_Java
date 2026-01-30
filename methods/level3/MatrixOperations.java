/*
Write a program to perform matrix manipulation operations like addition, subtraction, multiplication, and transpose. Also finding the determinant and inverse of a matrix. The program should take random matrices as input and display the result of the operations.
Hint => 
Write a Method to create a random matrix taking rows and columns as parameters
Write a Method to add two matrices
Write a Method to subtract two matrices
Write a Method to multiply two matrices
 */
import java.util.Random;

class MatrixOperations {

    // Method to create a matrix with random values between 1 and 9
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(9) + 1;
            }
        }
        return matrix;
    }

    // Method to add two matrices
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    // Method to subtract matrix b from matrix a
    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int[][] result = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    // Method to find transpose of a matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    // Method to find determinant of a 2x2 matrix
    public static int findDeterminant2x2(int[][] m) {
        return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
    }

    // Method to find inverse of a 2x2 matrix
    public static double[][] inverse2x2(int[][] m) {
        int det = findDeterminant2x2(m);
        if (det == 0) return null;

        double[][] inv = new double[2][2];
        inv[0][0] = m[1][1] / (double) det;
        inv[0][1] = -m[0][1] / (double) det;
        inv[1][0] = -m[1][0] / (double) det;
        inv[1][1] = m[0][0] / (double) det;

        return inv;
    }

    // Method to print integer matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    // Method to print double matrix
    public static void printMatrixDouble(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%.2f\t", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create two random 2x2 matrices
        int[][] A = createRandomMatrix(2, 2);
        int[][] B = createRandomMatrix(2, 2);

        // Display matrices
        System.out.println("Matrix A:");
        printMatrix(A);

        System.out.println("\nMatrix B:");
        printMatrix(B);

        // Perform and display matrix addition
        System.out.println("\nAddition:");
        printMatrix(addMatrices(A, B));

        // Perform and display matrix subtraction
        System.out.println("\nSubtraction:");
        printMatrix(subtractMatrices(A, B));

        // Perform and display matrix multiplication
        System.out.println("\nMultiplication:");
        printMatrix(multiplyMatrices(A, B));

        // Display transpose of matrix A
        System.out.println("\nTranspose of A:");
        printMatrix(transposeMatrix(A));

        // Find and display determinant of matrix A
        int det = findDeterminant2x2(A);
        System.out.println("\nDeterminant of A: " + det);

        // Find and display inverse of matrix A if it exists
        double[][] inverse = inverse2x2(A);
        if (inverse != null) {
            System.out.println("\nInverse of A:");
            printMatrixDouble(inverse);
        } else {
            System.out.println("\nInverse does not exist (Determinant = 0)");
        }
    }
}

