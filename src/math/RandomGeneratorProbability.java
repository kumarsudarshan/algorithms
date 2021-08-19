package math;

import java.util.Random;

/*
A dice is generating random number from 1 to 7,
We need to modify random number to generate number from 1 to 5 with equal probability
 */
public class RandomGeneratorProbability {
    public static void main(String[] args) {
        calculateProbability();
    }

    static int count = 0;

    public static int generate() {
        int ran1 = new Random().nextInt(7) + 1;
        int random = 0;
        if (ran1 < 6) {
            return ran1;
        } else {
            random = 1 + (count++) % 5;
        }
        return random;
    }

    public static int generate1() {
        int i;
        int ran1 = new Random().nextInt(7) + 1;
        int ran2 = new Random().nextInt(7) + 1;
        int ran3 = new Random().nextInt(7) + 1;
        int ran4 = new Random().nextInt(7) + 1;
        i = 7 * ran1 + ran2 + ran3 + ran4;
        return i % 5 + 1;
    }

    public static void calculateProbability() {
        int[] freq = new int[6];

        for (int i = 0; i < 10000000; i++) {
            int val = generate1();
            freq[val]++;
        }

        for (int i = 0; i <= 5; i++) {
            System.out.println(i + "   " + freq[i] / 100000.0);
        }
    }
}
