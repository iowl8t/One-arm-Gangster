package ed;

import java.util.Random;

import static java.lang.System.exit;

public class Casino{
    private int money;
    final private int maxRandValue = 7;
    private int[] randValuesAr = new int[3];
    final private int jackpotIndex = 8;

    Casino(){
        money = 5000;
    }

    private void makeRandValues(){
        Random r = new Random();
        for(int i = 0; i < 3; i++)
            randValuesAr[i] = r.nextInt(maxRandValue+1);

        for(int i = 0; i < 3; i++)
            System.out.print(randValuesAr[i]);
        System.out.print('\n');
    }


    private int[][] priseCombinations = {
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
            {7}
    };

    private void comparison() {
        int count = 0;
        for(int i = 0; i < priseCombinations.length; i++) {
            for (int j = 0; j < priseCombinations[i].length; j++) {
                if (randValuesAr[j] == priseCombinations[i][j])
                    count++;
            }
            if(count == priseCombinations[i].length) {
                prise(i);
                break;
            }
            count = 0;
        }



    }

    private int[] priseAr = {1100, 1000, 900, 800, 700, 600, 500, 100, 100, 25, 25};
    private void prise(int indexPriseAr) {
        if (indexPriseAr == jackpotIndex) {
            System.out.println("Congratulations! You just won the jackpot!");
            exit(0);
        }
        this.money += this.priseAr[indexPriseAr];
        System.out.println("Congratulations! You just won " + priseAr[indexPriseAr] +"grn!");
    }


    public void step(){
        if(this.money < 200) {
            System.out.println("You have no money. Game over.");
            exit(0);
        }
        money -= 200;
        makeRandValues();
        comparison();
        System.out.println("You have " + money + "grn.\n");
    }

}
