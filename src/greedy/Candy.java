package greedy;

/*
Candy
https://leetcode.com/problems/candy/
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

Input: ratings = [1,0,2], Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Input: ratings = [1,2,2], Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 */
public class Candy {

    public static void main(String[] args) {
        int[] ratings = {12, 4, 3, 11, 34, 34, 1, 67}; // 16
        System.out.println(candy(ratings));
    }

    // Time: O(n), Space: O(n)
    //      {12, 4, 3, 11, 34, 34, 1, 67}
    // left { 1, 1, 1,  2,  3,  1, 1,  2}
    // right{ 3, 2, 1,  1,  1,  2, 1,  1}
    // Total{ 3, 2, 1,  2,  3,  2, 1,  2}
    // Result = Sum of result = 16
    public static int candy(int[] ratings) {
        int numberOfChildren = ratings.length;
        int[] left = new int[numberOfChildren];
        int[] right = new int[numberOfChildren];
        int minimumCandy = 0;
        for (int i = 0; i < numberOfChildren; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        for (int i = numberOfChildren - 1; i >= 0; i--) {
            if (i < (numberOfChildren - 1) && ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        for (int i = 0; i < numberOfChildren; i++) {
            minimumCandy += Math.max(left[i], right[i]);
        }
        return minimumCandy;
    }

    // Time: O(n), Space O(1)
    // https://leetcode.com/problems/candy/solution/
    public static int candy1(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int candies = 0;
        int up = 0;
        int down = 0;
        int oldSlope = 0;
        for (int i = 1; i < ratings.length; i++) {
            int newSlope = (ratings[i] > ratings[i - 1]) ? 1
                    : (ratings[i] < ratings[i - 1] ? -1
                    : 0);

            if ((oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (newSlope > 0) {
                up++;
            } else if (newSlope < 0) {
                down++;
            } else {
                candies++;
            }

            oldSlope = newSlope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }

    public static int count(int n) {
        return (n * (n + 1)) / 2;
    }
}
