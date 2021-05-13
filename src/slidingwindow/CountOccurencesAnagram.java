package slidingwindow;

public class CountOccurencesAnagram {

/*
https://www.geeksforgeeks.org/count-occurrences-of-anagrams/
Count Occurrences of Anagrams
Given a word and a text, return the count of the occurrences of anagrams of the word in the text(For eg: anagrams of word for are for, ofr, rof etc.))

Examples:

Input : forxxorfxdofr
        for
Output : 3
Explanation : Anagrams of the word for - for, orf,
ofr appear in the text and hence the count is 3.

Input : aabaabaa
        aaba
Output : 4
Explanation : Anagrams of the word aaba - aaba,
abaa each appear twice in the text and hence the
count is 4.
*/

    private static int MAX_CHAR = 256;

    public static void main(String[] args) {
        System.out.println(anagramCount("aabaabaa", "aaba"));
    }

    public static int anagramCount(String text, String pattern) {
        int N = text.length();
        int k = pattern.length();

        int i = 0, j = 0;
        int[] count = new int[MAX_CHAR];
        int ans = 0;

        for (int p = 0; p < k; p++) {
            count[pattern.charAt(p)]++;
            count[text.charAt(p)]--;
        }
        if (countZero(count)) {
            ans++;
        }

        while (j < N) {
            if (j - i  < k) {
                j++;
            } else if (j - i == k) {
                count[text.charAt(j)]++;
                count[text.charAt(i)]--;
                if (countZero(count)) {
                    ans++;
                }
                i++;
                j++;
            }
        }
        return ans;
    }

    static boolean countZero(int[] count) {
        for (int i = 0; i < MAX_CHAR; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
