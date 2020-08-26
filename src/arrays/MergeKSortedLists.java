package arrays;

import java.util.PriorityQueue;

/*
 * 
 * Given lists of sorted list of integers, merge them into one large sorted list.

Can you do it better than O(kn log kn) where n is the length of the longest list, and k is the number of lists?

Example 1
Input

lists = [
    [],
    [],
    [10, 12],
    [],
    [3, 3, 13],
    [3],
    [10],
    [0, 7]
]
Output

[0, 3, 3, 3, 7, 10, 10, 12, 13]
 * 
 */

public class MergeKSortedLists {
	
	public static void main(String[] args) {
		int[][] lists = {
		         {},
		         {},
		         {10, 12},
		         {},
		         {3, 3, 13},
		         {3},
		         {10},
		         {0, 7}
		};
		MergeKSortedLists merge = new MergeKSortedLists();
		int[] res = merge.solve(lists);
		for(int i : res) {
			System.out.println(i);
		}
		int[] res1 = merge.solve1(lists);
		for(int i : res1) {
			System.out.println(i);
		}
	}
	
	// Approach 1
	public int[] solve(int[][] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int[] arr : lists){
            for(int i = 0 ; i < arr.length;i++){
                minHeap.add(arr[i]);
            }
        }
        int k = minHeap.size();
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = minHeap.poll();
        }
        return result;
    }
    // Approach 2
    int[] merge(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int len = n+m;
        int[] res = new int[len];
        int i=0;
        int j=0;
        int k=0;
        while(i<n&&j<m) {
            if(a[i]<b[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = b[j++];
            }
        }
        while(i<n) res[k++] = a[i++];
        while(j<m) res[k++] = b[j++];
        return res;
    }
    public int[] solve1(int[][] lists) {
        int res[] = lists[0];
        int n= lists.length;
        for(int i=1;i<n;i++) {
            res = merge(res,lists[i]);
        }
        return res;
    }
}
