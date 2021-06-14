package stack;

import java.util.Arrays;
import java.util.Stack;

/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and
we need to calculate span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day,
for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 */
public class StockSpanProblem {
    public static void main(String[] args) {
        Arrays.stream(stockSpan(new int[]{100, 80, 60, 70, 60, 75, 85})).forEach(i -> System.out.print(i + "  ")); // 2, 2, -1, -1
    }

    // similar to next greater element to left
    public static int[] stockSpan(int[] price) {
        Stack<Pair> stack = new Stack<>();
        int[] stock = new int[price.length];
        for (int i = 0; i < price.length; i++) {
            if (stack.size() == 0) {
                stock[i] = -1;
            } else if (stack.size() > 0 && stack.peek().x > price[i]) {
                stock[i] = stack.peek().y;
            } else if (stack.size() > 0 && stack.peek().x <= price[i]) {
                while (stack.size() > 0 && stack.peek().x <= price[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    stock[i] = -1;
                } else {
                    stock[i] = stack.peek().y;
                }
            }
            stack.push(new Pair(price[i], i));
        }
        for (int i = 0; i < price.length; i++) {
            stock[i] = i - stock[i];
        }
        return stock;
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
