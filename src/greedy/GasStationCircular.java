package greedy;

/*
Gas Station
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the
circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2], Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.

Input: gas = [2,3,4], cost = [3,4,3], Output: -1
Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
 */
public class GasStationCircular {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }

    // Time: O(n), Space : O(n)
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        // base case for length 1
        if (n == 1)
            return (gas[0] - cost[0] >= 0 ? 0 : -1);

        // index tracks what is the best station to start with
        int index = -1;

        // keep count of accumlated gas does not care about negative or positive
        int[] dp = new int[n + 1];

        // keep track of current gas and cost difference
        int[] gasCheck = new int[n + 1];
        for (int i = 0; i < gas.length; i++) {

            dp[i + 1] = dp[i] + gas[i] - cost[i];
            gasCheck[i + 1] = gas[i] - cost[i];
            // if there was no better station before and current gas station gives more gas to move forward use it
            if (gasCheck[i + 1] > 0 && index == -1) {
                index = i;
            }
            // if current gas is in negative(cannot move forward and also current gas with previous station's gas is less then reset index.
            else if (dp[i + 1] < 0 && gasCheck[i + 1] + gasCheck[i] < 0)
                index = -1;
        }

        if (dp[n] >= 0)
            return index;
        else
            return -1;
    }

    // Optimized
    // Time: O(n), Space : O(1)
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        //Local optimization: If the current accumulated remaining fuel is less than 0, the update starting point is the next point
        // Global Optimal: Find a starting position where you can run a lap

        int currSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            currSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];

            if (currSum < 0) {
                //The current accumulated daily remaining fuel amount is less than 0
                start = i + 1; // Update starting point and current sum
                currSum = 0;
            }
        }

        if (totalSum < 0)
            return -1; // All accumulated remaining fuel is less than 0， It means it's impossible to run a lap no matter what
        return start;
    }

}
