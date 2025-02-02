package lab1.t2;

import java.util.Scanner;

public class AlternatingSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            int number = scanner.nextInt();

            if (i % 2 == 1) {
                sum += number;
            } else {
                sum -= number;
            }
        }

        System.out.println(sum);
    }
}