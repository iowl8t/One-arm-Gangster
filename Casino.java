package ed;

import java.util.Random;
import static java.lang.System.exit;


abstract public class Casino implements GlobalCasino {
    private int money;
    final private int minBet;

    final private int maxRandValue;
    private int[] randValuesAr;

    final private int jackpotIndex;
    final private int penaltyIndex;

    private int[] priseAr;
    private int[][] priseCombinationsAr;

    Casino(int money, int maxRandValue, int lengthOfRandValuesAr, int jackpotIndex, int penaltyIndex, int minBet, int[] priseAr, int[][] priseCombinationsAr) {
        this.money = money;
        this.maxRandValue = maxRandValue;
        this.randValuesAr = new int[lengthOfRandValuesAr];
        this.jackpotIndex = jackpotIndex;
        this.penaltyIndex = penaltyIndex;
        this.minBet = minBet;
        this.priseAr = priseAr;
        this.priseCombinationsAr = priseCombinationsAr;
    }

    public void welcomeWords() {
        System.out.println("Welcome to Casino!");
    }

    //Fill randValuesAr[] with random values from 0 to maxRandValue
    private void makeRandValues() {
        Random r = new Random();
        for (int i = 0; i < randValuesAr.length; i++)
            randValuesAr[i] = r.nextInt(maxRandValue + 1);

        System.out.print("Random combination: ");
        for (int i = 0; i < randValuesAr.length; i++)
            System.out.print(randValuesAr[i] + " ");
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
        if (money < minBet) {
            System.out.println("You have no money. Game over.");
            exit(0);
        }
        money -= minBet;
        makeRandValues();
        comparison();
        System.out.println("You have " + money + "grn.\n");
    }
}
