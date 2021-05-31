package fastslowpointer;

/*
Any number will be called a happy number if, after repeatedly replacing it
with a number equal to the sum of the square of all of its digits,
leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’.
Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

Example:
Input: 23
Output: true (23 is a happy number)
Explanations: Here are the steps to find out that 23 is a happy number:
2^2 + 3^2 = 4 + 9 = 13
1^2 + 3^2 = 1 + 9 = 10
1^2 + 0^2 = 1 + 0 = 1
*/
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappyNumber(23));
        System.out.println(isHappyNumber(12));
    }

    public static boolean isHappyNumber(int num) {
        int slow = num, fast = num;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(digitSquareSum(fast));
        } while (slow != fast); // if these is cycle, then definitely slow == flow.
        return slow == 1; // if slow != 1, means there is cycle and both slow and fast meet at some number say k.
    }

    public static int digitSquareSum(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num = num / 10;
        }
        return sum;
    }
}
