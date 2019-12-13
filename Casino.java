package ed;

import java.util.Random;
import static java.lang.System.exit;


public class Casino {
    private int money;
    final private int maxRandValue = 7;
    private int[] randValuesAr = new int[3];
    final private int jackpotIndex = 6;
    final private int penaltyIndex = 11;
    final private int[] priseAr = {1100, 1000, 900, 800, 700, 600, 500, 200, 100, 30, 25, 1000};
    final private int[][] priseCombinationsAr = {
            {0, 0, 0},
            {1, 1, 1},
            {2, 2, 2},
            {3, 3, 3},
            {4, 4, 4},
            {5, 5, 5},
            {7, 7, 7},
            {7, 7},
            {5, 5},
            {5},
            {7},
            {6, 6, 6}
    };

    Casino() {
        money = 5000;
    }

    //Fill randValuesAr[3] with random values from 0 to maxRandValue
    private void makeRandValues() {
        Random r = new Random();
        for (int i = 0; i < 3; i++)
            randValuesAr[i] = r.nextInt(maxRandValue + 1);

        for (int i = 0; i < 3; i++)
            System.out.print(randValuesAr[i]);
        System.out.print('\n');
    }

    //Comparing random values with prise combinations
    private void comparison() {
        int count = 0;
        for (int i = 0; i < priseCombinationsAr.length; i++) {
            for (int j = 0; j < priseCombinationsAr[i].length; j++) {
                if (randValuesAr[j] == priseCombinationsAr[i][j])
                    count++;
            }
            if (count == priseCombinationsAr[i].length) {
                prise(i);
                break;
            }
            count = 0;
        }
    }

    //Realization of prizes and penalties
    private void prise(int indexPriseAr) {
        if (indexPriseAr == jackpotIndex) {
            System.out.println("Congratulations! You just won the jackpot!");
            exit(0);
        }
        if (indexPriseAr == penaltyIndex) {
            money -= priseAr[indexPriseAr];
            System.out.println("Penalty combination! You just lost " + priseAr[indexPriseAr] + "grn!");
        } else {
            money += priseAr[indexPriseAr];
            System.out.println("Congratulations! You just won " + priseAr[indexPriseAr] + "grn!");
        }
    }

    //Call it to do player's move
    public void step() {
        if (this.money < 200) {
            System.out.println("You have no money. Game over.");
            exit(0);
        }
        money -= 200;
        makeRandValues();
        comparison();
        System.out.println("You have " + money + "grn.\n");
    }
}
