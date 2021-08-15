package graph;

/*
Find the Town Judge
https://leetcode.com/problems/find-the-town-judge/
In a town, there are n people labelled from 1 to n.  There is a rumour that one of these people is secretly the town judge.
If the town judge exists, then:
1.	The town judge trusts nobody.
2.	Everybody (except for the town judge) trusts the town judge.
3.	There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
Example 1. Input: n = 2, trust = [[1,2]] Output: 2
Example 2. Input: n = 3, trust = [[1,3],[2,3],[3,1]] Output: -1
Example 3. Input: n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]] Output: 3

 */

public class TownJudge {
    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][]{{1, 2}}));
        System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
        System.out.println(findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
    }

    public static int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return 1;
        }
        int[] helper = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            helper[trust[i][0]]--;
            helper[trust[i][1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (helper[i] == (n - 1)) {
                return i;
            }
        }
        return -1;
    }

}
