package math;

public class CatalanNumber {
    public static void main(String[] args) {
        System.out.println(catalanRecursive(5));
        System.out.println(catalanDP(5));
        System.out.println(catalan(5));
    }

    // Recursive
    // Time : Exponential :  SUM(T(i)*T(n - i - 1))
    static long catalanRecursive(int n) {
        if (n <= 1) {
            return 1;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catalanRecursive(i) * catalanRecursive(n - i - 1);
        }
        return ans;
    }

    // DP, Time: O(n^2), Space: O(n)
    static long catalanDP(int n) {

        if (n <= 1) return 1;
        long[] dp = new long[n + 1];
        dp[0] = dp[1] = 1;
        long ans = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    // Using Binomial Coefficient
    // Catalan numbers can also be represented as Catalan(n)=(2n)C(n)/(n+1)
    // Time : O(n), Space O(1)
    static long catalan(int n) {

        long res = binomialCoeff(2 * n, n);
        return res / (n + 1);
    }

    static long binomialCoeff(int n, int k) {
        long ans = 1;

        for (int i = 0; i < k; ++i) {
            ans *= (n - i);
            ans /= (i + 1);
        }
        return ans;
    }
}
