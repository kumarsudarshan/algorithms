package bitwise;

public class ElementAppearedOnce {

    public static void main(String args[]) {
        int[] arr = { 5, 5, 4, 8, 4, 5, 8, 9, 4, 8 };
        System.out.print("Input Matrix : ");

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "  ");

        /*
         *  Since all elements in the input array, except one, occur 3 times,
         *  pass 3 as argument in call to findRequiredNum.
         */
        System.out.println("\n\nThe number which occured only once is: " + findRequiredNum(arr, 3));
    }

    public static int findRequiredNum(int arr[], int N) {
        // For counting set bits in all given numbers.
        int countSetBit[] = new int[32];

        // For each element run the loop.
        for (int i = 0; i < arr.length; i++) {
            // Find the set bits in the current element.
            for (int k = 0; k < 32; k++) {
                int kthSetBit = 1 << k;
                // If the kth bit is set, then increment the count of countSetBit[k].
                if ((arr[i] & kthSetBit) == kthSetBit)
                    countSetBit[k]++;
            }
        }

        // Required number.
        int occurredOnce = 0;

        // Iterate over countSetBit.
        for (int i = 0; i < 32; i++) {
            /*
             *  Find the remainder of each element with N so as to see what is
             *  the representation of the single occurred element.
             */
            countSetBit[i] = countSetBit[i] % N;

            /*
             * After mod operation, each element of countSetBit represent bits
             * of required element(occurredOnce). Therefore, set ith bit in
             * occurredOnce if countSetBit[i] is 1.
             */
            if (countSetBit[i] == 1)
                occurredOnce = occurredOnce | (1 << i);
        }
        return occurredOnce;
    }


}
