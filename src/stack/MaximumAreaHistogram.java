package stack;

import java.util.Stack;

/*
Largest Rectangular Area in a Histogram
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars.
For simplicity, assume that all bars have same width and the width is 1 unit.
For example, consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 1, 6}. The largest possible rectangle possible is 12
 */
public class MaximumAreaHistogram {
    public static void main(String[] args) {
        System.out.println(mah(new int[]{6, 2, 5, 4, 5, 1, 6}));
    }

    public static int mah(int[] hist) {
        int n = hist.length;
        int[] nsr = new int[n];
        int[] nsl = new int[n];
        int[] width = new int[n];
        Stack<Pair> stack = new Stack<>();
        // calculating nearest smaller to left
        for (int i = 0; i < hist.length; i++) {
            if (stack.size() == 0) {
                nsl[i] = -1;
            } else if (stack.size() > 0 && stack.peek().x < hist[i]) {
                nsl[i] = stack.peek().y;
            } else if (stack.size() > 0 && stack.peek().x >= hist[i]) {
                while (stack.size() > 0 && stack.peek().x >= hist[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    nsl[i] = -1;
                } else {
                    nsl[i] = stack.peek().y;
                }
            }
            stack.push(new Pair(hist[i], i));
        }
        // calculating nearest smaller to right
        stack.clear();
        for (int i = hist.length - 1; i >= 0; i--) {
            if (stack.size() == 0) {
                nsr[i] = n;
                stack.push(new Pair(nsr[i], i));
            } else if (stack.size() > 0 && stack.peek().x < hist[i]) {
                nsr[i] = stack.peek().y;
            } else if (stack.size() > 0 && stack.peek().x >= hist[i]) {
                while (stack.size() > 0 && stack.peek().x >= hist[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    nsr[i] = n;
                } else {
                    nsr[i] = stack.peek().y;
                }
            }
            stack.push(new Pair(hist[i], i));
        }
        // calculating area = width[i]*height[i], width[i] = nsr[i] - nsl[i] - 1;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (nsr[i] - nsl[i] - 1) * hist[i]);
        }
        return maxArea;
    }
}
