package ed;


public class DeceptivePlace extends Casino {

    static final private int[] priseAr = {1100, 1000, 900, 800, 700, 600, 500, 200, 100, 30, 25, 1000};

    static final private int[][] priseCombinationsAr = {
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

    DeceptivePlace() {
        super(5000, 7, 3, 6, 11, 200, priseAr, priseCombinationsAr);
    }

    @Override
    public void welcomeWords() {
        System.out.println("Welcome to a Deceptive Place!");
    }
}
