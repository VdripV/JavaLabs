package lab2.t4;

import java.util.Arrays;
import java.util.Scanner;

public class RotateMatrixClockwise {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the size of the matrix: ");
        int size = inputScanner.nextInt();
        int[][] matrix = new int[size][size];
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = inputScanner.nextInt();
            }
        }
        int[][] rotatedMatrix = rotateClockwise(matrix);
        System.out.println("Rotated matrix:");
        printMatrix(rotatedMatrix);
    }

    public static int[][] rotateClockwise(int[][] matrix) {
        int size = matrix.length;
        int[][] rotated = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotated[j][size - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}