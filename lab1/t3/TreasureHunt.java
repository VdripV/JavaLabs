package lab1.t3;

import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        int treasureX = inputScanner.nextInt();
        int treasureY = inputScanner.nextInt();

        int playerX = 0;
        int playerY = 0;

        int moveCount = 0;
        boolean isTreasureFound = false;

        while (true) {
            String directionInput = inputScanner.next();
            if (directionInput.equals("стоп")) {
                break;
            }

            int moveSteps = inputScanner.nextInt();

            if (!isTreasureFound) {

                switch (directionInput) {
                    case "север":
                        playerY += moveSteps;
                        break;
                    case "юг":
                        playerY -= moveSteps;
                        break;
                    case "восток":
                        playerX += moveSteps;
                        break;
                    case "запад":
                        playerX -= moveSteps;
                        break;
                }
                moveCount++;

                if (playerX == treasureX && playerY == treasureY) {
                    isTreasureFound = true;
                }
            }
        }

        System.out.println(moveCount);
    }
}