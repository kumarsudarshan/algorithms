package backtrack;

/*
Letter Combinations of a Phone Number
https://www.interviewbit.com/blog/letter-combinations-of-a-phone-number/

Problem Statement
Given a digit string, return all possible letter combinations that the number could represent.
 A mapping of digits to letters (just like on the telephone buttons) is given below.

The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

1 = ""
2 = "abc"
3 = "def"
4 = "ghi"
5 = "jkl"
6 = "mno"
7 = "pqrs"
8 = "tuv"
9 = "wxyz"

Examples:
Input: Digit = “23”
Output: [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf”].
Explanation:   The list shows the different possible combinations of the strings possible.

“ad” – Press digit 2 once, digit 3 once.
“ae”-   Press digit 2 once, digit 3 twice
“af” –  Press digit 2 twice, digit 3 once, and so on.
Input:   Digit = “2”
Output: [“a”, “b”, “c”]
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationOfPhoneNumber letters = new LetterCombinationOfPhoneNumber();
//        System.out.println(letters.allPossibleCombinations("3"));
            // [d, e, f]
        System.out.println(letters.allPossibleCombinations("34"));
                // [dg, dh, di, eg, eh, ei, fg, fh, fi]

//        System.out.println(letters.allPossibleCombinations("345"));
        // [dgj, dgk, dgl, dhj, dhk, dhl, dij, dik, dil,
        // egj, egk, egl, ehj, ehk, ehl, eij, eik, eil,
        // fgj, fgk, fgl, fhj, fhk, fhl, fij, fik, fil]
    }
    private Map<Character, String> numPad = buildNumPadMap();
    private List<String> results = new ArrayList<>();
    private Map<Character, String> buildNumPadMap(){
        Map<Character, String> numPad = new HashMap<>();
        numPad.put('1',"");
        numPad.put('2', "abc");
        numPad.put('3', "def");
        numPad.put('4', "ghi");
        numPad.put('5', "jkl");
        numPad.put('6', "mno");
        numPad.put('7', "pqrs");
        numPad.put('8', "tuv");
        numPad.put('9', "wxyz");
        return numPad;
    }

    private List<String> allPossibleCombinations(String code) {
        if(code.length() == 0) {
            return results;
        }
        allPossibleCombinationsHelper(0, code);
        return results;
    }

    String possibleString = "";
    private void allPossibleCombinationsHelper(int index, String code) {
        if(possibleString.length() == code.length()) {
            results.add(possibleString + "");
            return;
        }
        String lettersAtNumber = numPad.get(code.charAt(index));
        for(char letter : lettersAtNumber.toCharArray()){
            possibleString = possibleString + letter;
            allPossibleCombinationsHelper(index + 1, code);
            possibleString = possibleString.substring(0, possibleString.length() - 1);
        }
    }
}
