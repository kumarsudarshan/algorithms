package heap.topkelements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
'K' Closest Numbers (medium)
Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’ closest numbers to ‘X’ in the array. Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.
Input: [5, 6, 7, 8, 9], K = 3, X = 7
Output: [6, 7, 8]
Input: [2, 4, 5, 6, 9], K = 3, X = 6
Output: [4, 5, 6]
Input: [2, 4, 5, 6, 9], K = 3, X = 10
Output: [5, 6, 9]
 */
public class KClosetNumbers {
    public static void main(String[] args) {
        System.out.println(kClosetNumbers(new int[]{5, 6, 7, 8, 9}, 3, 7)); // [6, 7, 8]
        System.out.println(kClosetNumbers(new int[]{2, 4, 5, 6, 9}, 3, 6)); // [4, 5, 6]
        System.out.println(kClosetNumbers(new int[]{2, 4, 5, 6, 9}, 3, 10)); // [5, 6, 9]

        // alternate approach
        System.out.println(kClosetNumbersUsingTwoPointer(new int[]{5, 6, 7, 8, 9}, 3, 7)); // [6, 7, 8]
        System.out.println(kClosetNumbersUsingTwoPointer(new int[]{2, 4, 5, 6, 9}, 3, 6)); // [4, 5, 6]
        System.out.println(kClosetNumbersUsingTwoPointer(new int[]{2, 4, 5, 6, 9}, 3, 10)); // [5, 6, 9]
    }

    public static List<Integer> kClosetNumbers(int[] nums, int k, int x) {
        int index = binarySearch(nums, x);
        int start = index - k;
        int end = index + k;
        start = Math.max(start, 0);
        end = Math.min(end, nums.length - 1);

        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>((p1, p2) -> p1.x - p2.x);

        for (int i = start; i <= end; i++) {
            minHeap.offer(new Pair(Math.abs(nums[i] - x), nums[i]));
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(minHeap.poll().y);
        }
        Collections.sort(result);
        return result;
    }

    public static List<Integer> kClosetNumbersUsingTwoPointer(int[] nums, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int index = binarySearch(nums, x);
        int leftPointer = index;
        int rightPointer = index + 1;
        for (int i = 0; i < k; i++) {
            if (leftPointer >= 0 && rightPointer < nums.length) {
                int diff1 = Math.abs(x - nums[leftPointer]);
                int diff2 = Math.abs(x - nums[rightPointer]);
                if(diff1 <= diff2){
                    result.add(0, nums[leftPointer--]); // append at the beginning
                } else{
                    result.add(nums[rightPointer++]); // append at the end
                }
            } else if (leftPointer >= 0) {
                result.add(0, nums[leftPointer--]);
            } else if (rightPointer < nums.length) {
                result.add(nums[rightPointer++]);
            }
        }
        return result;
    }

    public static int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start > 0) {
            return start - 1;
        }
        return start;
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}