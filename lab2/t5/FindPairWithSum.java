package lab2.t5;

import java.util.HashSet;
import java.util.Scanner;

public class FindPairWithSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] nums = new int[size];
        System.out.print("Enter the array elements: ");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.print("Enter the target: ");
        int target = scanner.nextInt();
        int[] result = findPair(nums, target);
        if (result != null) {
            System.out.println("Pair: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found.");
        }
    }

    public static int[] findPair(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) {
                return new int[]{num, target - num};
            }
            set.add(num);
        }
        return null;
    }
}