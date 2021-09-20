package bitwise;

public class TwoElementAppearedOnce {
    public static void main(String[] args) {
        int[] arr = findTwoElementAppearedOnce(new int[]{1, 2, 1, 3, 2, 5});
        System.out.println(arr[0] + ", " + arr[1]); // 5, 3
    }

    public static int[] findTwoElementAppearedOnce(int[] nums) {
        // first take xor for all the elements
        // e.g. {1, 2, 1, 3, 2, 5}
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // now xor = 3^5, bitwise = 110
        // we need to find the first set bit from right
        // so formula is: x & (2's complement)
        // e.g. 110 & (2's complement of 110)
        // 2's complement of 110 = 001 + 1 = 010
        // lowest set bit = 010
        // now we divide the whole element into two group,
        // Group1 (lowestSetBit & num) == 0, i.e. whose 2nd right most bit is 0
        // Group2 (lowestSetBit & num) == 1, i.e. whose 2nd right most bit is 1
        int lowestSetBit = xor & (-xor);
        int[] result = new int[2];
        for (int num : nums) {
            if ((lowestSetBit & num) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
