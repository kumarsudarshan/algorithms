package backtrack;

import java.util.ArrayList;
import java.util.List;

/*
Print all permutations of string
 */
public class AllPermutationOfString {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        allPermutations("aabb", "", result);
        System.out.println(result);
    }

    public static void allPermutations(String str, String answer, List<String> result) {
        if (str.length() == 0) {
            result.add(answer);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // rest of the string after excluding current character
            String rest = str.substring(0, i) + str.substring(i + 1);
            allPermutations(rest, answer + ch, result);
        }
    }
}
