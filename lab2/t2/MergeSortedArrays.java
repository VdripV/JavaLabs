package lab2.t2;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortedArrays {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter the size of the first array: ");
        int[] firstArray = readArray(inputScanner);

        System.out.print("Enter the size of the second array: ");
        int[] secondArray = readArray(inputScanner);

        int[] mergedArray = mergeSortedArrays(firstArray, secondArray);
        System.out.println("Result: " + Arrays.toString(mergedArray));
    }

    public static int[] mergeSortedArrays(int[] firstArray, int[] secondArray) {
        int[] mergedResult = new int[firstArray.length + secondArray.length];
        int i = 0, j = 0, resultIndex = 0;

        while (i < firstArray.length && j < secondArray.length) {
            mergedResult[resultIndex++] = (firstArray[i] < secondArray[j]) 
                ? firstArray[i++] 
                : secondArray[j++];
        }
        while (i < firstArray.length) mergedResult[resultIndex++] = firstArray[i++];
        while (j < secondArray.length) mergedResult[resultIndex++] = secondArray[j++];
        return mergedResult;
    }

    private static int[] readArray(Scanner inputScanner) {
        int arraySize = inputScanner.nextInt();
        int[] array = new int[arraySize];
        System.out.print("Enter sorted items: ");
        for (int i = 0; i < arraySize; i++) {
            array[i] = inputScanner.nextInt();
        }
        return array;
    }
}