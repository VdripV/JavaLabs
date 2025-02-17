package lab2.t8;

import java.util.Arrays;
import java.util.Scanner;

public class RotateMatrixCounterClockwise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the matrix: ");
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int[][] rotated = rotateCounterClockwise(matrix);
        System.out.println("Rotation result:");
        printMatrix(rotated);
    }

    public static int[][] rotateCounterClockwise(int[][] matrix) {
        int size = matrix.length;
        int[][] rotated = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotated[n - 1 - j][i] = matrix[i][j];
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