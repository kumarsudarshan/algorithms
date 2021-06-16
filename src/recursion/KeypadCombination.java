package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Print all possible words from phone digits
Before the advent of QWERTY keyboards, texts and numbers were placed on the same key.
For example, 2 has “ABC” if we wanted to write anything starting with ‘A’ we need to type key 2 once.
If we wanted to type ‘B’, press key 2 twice and thrice for typing ‘C’. Below is a picture of such a keypad.

Example:
Input number: 234
Output:
adg adh adi aeg aeh aei afg afh
afi bdg bdh bdi beg beh bei bfg
bfh bfi cdg cdh cdi ceg ceh cei
cfg cfh cfi
Explanation: All possible words which can be
formed are (Alphabetical order):
adg adh adi aeg aeh aei afg afh
afi bdg bdh bdi beg beh bei bfg
bfh bfi cdg cdh cdi ceg ceh cei
cfg cfh cfi
If 2 is pressed then the alphabet
can be a, b, c,
Similarly, for 3, it can be
d, e, f, and for 4 can be g, h, i.
 */
public class KeypadCombination {
    public static void main(String[] args) {
        System.out.println(printKPC("234"));
        System.out.println(printKPC("5"));
    }

    static String[] codes = {".;", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> printKPC(String str) {
        List<String> result = new ArrayList<>();
        if (str.length() == 0) {
            result.add("");
            return result;
        }
        char ch = str.charAt(0);
        String temp1 = str.substring(1);
        List<String> temp2 = printKPC(temp1);
        String codeCh = codes[ch - '0'];
        for (char c : codeCh.toCharArray()) {
            for (String s : temp2) {
                result.add(c + s);
            }
        }
        return result;
    }


}
