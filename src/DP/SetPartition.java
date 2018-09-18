/*
    Created by : Kumar Sudarshan
    Date : 30th Aug 2018
    Given a set, find out if it can be partitioned into two disjoint subsets such that sum of the elements in both these subsets is equal. Intersection of disjoint sets should be null and union should be the complete set.
For set {7,5,3,5}, sets {7,5} and {3,5} are valid disjoint sets. Also sets {7,5,3,5} and {} are valid disjoint sets. But sets {7,5,3} and {3,5} are not valid disjoint sets since element 3 is present in both of these subsets.
 */

package DP;

public class SetPartition {

    public static void main(String[] args) {
        int[] arr = {7,5,3,5};
        System.out.println(partition(arr));
    }

    private static boolean partition(int[] arr) {
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum +=arr[i];
        }
        // if sum is odd, there is no chance to divide in to two equal parts.
        if(sum%2!=0){
            return false;
        }
        boolean part[][]=new boolean[sum/2+1][arr.length+1];

        // initialize top row as true
        for (int i = 0; i <= arr.length; i++)
            part[0][i] = true;

        // initialize leftmost column, except part[0][0], as 0
        for (int i = 1; i <= sum/2; i++)
            part[i][0] = false;

        // Fill the partition table in botton up manner
        for (int i = 1; i <= sum/2; i++) {
            for (int j = 1; j <= arr.length; j++) {
                part[i][j] = part[i][j-1];
                if(i >= arr[j-1]){
                    part[i][j] = part[i][j] || part[i-arr[j-1]][j-1];
                }
            }
        }
        return part[sum/2][arr.length];
    }

}
