package DP.lis;

import java.util.Arrays;

/*
Maximum Length Chain of Pairs
You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
A pair (c, d) can follow another pair (a, b) if b < c.
Chain of pairs can be formed in this fashion. Find the longest chain which can be formed from a given set of pairs.
For example,
if the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} },
then the longest chain that can be formed is of length 3,
and the chain is {{5, 24}, {27, 40}, {50, 90}}
 */
public class LongestChain {
    public static void main(String[] args) {
        Pair[] pairs = {new Pair(5, 24), new Pair(39, 60), new Pair(15, 28), new Pair(27, 40), new Pair(50, 90)};
        System.out.println(longestChain(pairs));
    }

    public static int longestChain(Pair[] pairs) {
        int N = pairs.length;
        int[] maxChainLengthArr = new int[N];
        Arrays.fill(maxChainLengthArr, 1); // atleast current pair will there

        int longestChainLength = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i].x > pairs[j].y && maxChainLengthArr[i] < maxChainLengthArr[j] + 1) {
                    maxChainLengthArr[i] = maxChainLengthArr[j] + 1;
                    longestChainLength = Math.max(longestChainLength, maxChainLengthArr[i]);
                }
            }
        }
        return longestChainLength;
    }
}

/*
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 */