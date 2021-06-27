package greedy;

import java.util.PriorityQueue;

/*
Minimum Number of Refueling Stops
A car travels from a starting position to a destination which is target miles east of the starting position.
There are gas stations along the way. The gas stations are represented as an array stations where
stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of the starting position and has fueli liters of gas.
The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.
It uses one liter of gas per one mile that it drives.
When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

Return the minimum number of refueling stops the car must make in order to reach its destination.
If it cannot reach the destination, return -1.
Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.
If the car reaches the destination with 0 fuel left, it is still considered to have arrived.

Input: target = 1, startFuel = 1, stations = []
Output: 0
Explanation: We can reach the target without refueling.

Input: target = 100, startFuel = 1, stations = [[10,100]]
Output: -1
Explanation: We can not reach the target (or even the first gas station).

Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
Output: 2
Explanation: We start with 10 liters of fuel.
We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
We made 2 refueling stops along the way, so we return 2.

 */
public class MinimumRefuelingStops {
    public static void main(String[] args) {
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        System.out.println(minRefuelStops(100, 10, stations));
    }

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {

        /*  Approach:

            We will create a priority queue which will store the the fuels (arr[i][1]) in descending order
            The stations with more fuel will be ahead (reverse sorting) so that max fuel can be taken when needed

        */

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);

        int countStops = 0;
        int currentStation = 0;
        int currentFuel = startFuel;

        // Loop till current fuel is less than required fuel. Else return as currFuel is sufficient to reach target.

        while (currentFuel < target) {

            // Traverse next station till current station are not completed.
            // and current fuel is more than sufficient to reach current station

            while (currentStation < stations.length && currentFuel >= stations[currentStation][0]) {
                maxHeap.add(stations[currentStation][1]);
                currentStation++;
            }

            // If at any time no element present, means till we reach nearest fuel pump, car already exhausted.
            if (maxHeap.size() <= 0) {
                return -1;  // not possible.
            }

            // When above while loop breaks, then update current fuel to add more Max(fuels seen till now)
            currentFuel = currentFuel + maxHeap.remove();
            countStops++;

        }

        return countStops;

    }
}
