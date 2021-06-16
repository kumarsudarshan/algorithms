package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Print all Possible Decoding of a given Digit Sequence
Given the numeric string str, where 1 represents ‘a’, 2 represents ‘b’, …, 26 represents ‘z’,
the task is to print all possible alphabetical strings that can be obtained from str.

Examples:
Input: str = “1123”
Output:
aabc
kbc
alc
aaw
kw
Explanation:
The given string can be splitted as:
1) “1123” = “1” + “1” + “2” + “3” = aabc
2) “1123” = “11” + “2” + “3” = kbc
3) “1123” = “1” + “12” + “3” = alc
4) “1123” = “1” + “1” + “23” = aaw
5) “1123” = “11” + “23” = aabc

Input: str = “56”
Output:
ef
Explanation:
The given string can be splitted as:
1) “56” = “5” + “6” = ef
 */
public class PrintEncoding {
    static Map<Integer, Character> codes;

    public static void main(String[] args) {
        Arrays.stream(getCodes("1123")).forEach(i -> System.out.println(i));
    }

    public static String[] getCodes(String str) {
        if (str == null || str.length() == 0) {
            String[] ans = {""};
            return ans;
        }
        int firstDigit = str.charAt(0) - '0';
        int firstTwoDigit = 0;

        String[] output1 = getCodes(str.substring(1));
        String[] output2 = new String[0];

        if (str.length() > 1) {
            firstTwoDigit = (str.charAt(0) - '0') * 10 + (str.charAt(1) - '0');
            if (firstTwoDigit >= 10 && firstTwoDigit <= 26) {
                output2 = getCodes(str.substring(2));
            }
        }

        String[] output = new String[output1.length + output2.length];

        int k = 0;
        for (int i = 0; i < output1.length; i++) {
            output[i] = ((char) (firstDigit + 96)) + output1[i];
            k++;
        }
        for (int i = 0; i < output2.length; i++) {
            output[k] = ((char) (firstTwoDigit + 96)) + output2[i];
            k++;
        }
        return output;
    }

}
