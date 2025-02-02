package lab1.t4;

import java.util.Scanner;

public class LogisticMaximin {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numberOfRoads = inputScanner.nextInt();

        int optimalRoad = -1;
        int maxHeight = -1;

        for (int roadIndex = 1; roadIndex <= numberOfRoads; roadIndex++) {
            int numberOfTunnels = inputScanner.nextInt();
            int minimumHeight = Integer.MAX_VALUE;

            for (int tunnelIndex = 0; tunnelIndex < numberOfTunnels; tunnelIndex++) {
                int tunnelHeight = inputScanner.nextInt();
                if (tunnelHeight < minimumHeight) {
                    minimumHeight = tunnelHeight;
                }
            }

            if (minimumHeight > maxHeight) {
                maxHeight = minimumHeight;
                optimalRoad = roadIndex;
            }
        }

        System.out.println(optimalRoad);
        System.out.println(maxHeight);
    }
}