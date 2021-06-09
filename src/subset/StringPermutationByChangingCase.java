package subset;

import java.util.ArrayList;
import java.util.List;

/*
String Permutations by changing case (medium)
Given a string, find all of its permutations preserving the character sequence but changing case.
Input: "ad52"
Output: "ad52", "Ad52", "aD52", "AD52"
Input: "ab7c"
Output: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"
 */
public class StringPermutationByChangingCase {
    public static void main(String[] args) {
        System.out.println(letterCasePermutations("ad52"));
        System.out.println(letterCasePermutations("ab7c"));
    }

    public static List<String> letterCasePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null) {
            return permutations;
        }
        // add the default string i.e. input itself
        permutations.add(str);
        // process every character of the string one by one.
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) { // skip digits, only characters
                // we will take all permutations and change the letter case appropriately
                int n = permutations.size();
                for (int j = 0; j < n; j++) {
                    char[] chs = permutations.get(j).toCharArray();
                    // if the current character is in uppercase change it to lowercase or vice versa
                    if (Character.isUpperCase(chs[i])) {
                        chs[i] = Character.toLowerCase(chs[i]);
                    } else {
                        chs[i] = Character.toUpperCase(chs[i]);
                    }
                    // add new string it to the answers
                    permutations.add(String.valueOf(chs));
                }
            }
        }
        return permutations;
    }
}
