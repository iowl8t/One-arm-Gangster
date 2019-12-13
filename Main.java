package ed;

import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Casino casino = new Casino();
        do {
            char ch;
            String s = "p";
            System.out.print("To play press \"p\": ");
            while(!s.equals(in.next()));

            casino.step();

        }while(true);

    }
}
