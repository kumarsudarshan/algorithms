package twopointer;

/*
Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
Input: str1="xy#z", str2="xzz#", Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
Input: str1="xy#z", str2="xyz#", Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
Input: str1="xp#", str2="xyz##", Output: true
Explanation: After applying backspaces the strings become "x" and "x" respectively.
In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
Input: str1="xywrrmp", str2="xywrrmu#p", Output: true
Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.

 */

public class ComparingStringsBackspaces {
    public static void main(String[] args) {
        System.out.println(compare("xy#z", "xzz#"));
        System.out.println(compare("xy#z", "xyz#"));
        System.out.println(compare("xp#", "xyz##"));
        System.out.println(compare("xywrrmp", "xywrrmu#p"));
    }

    public static boolean compare(String str1, String str2) {
        int index1 = str1.length() - 1;
        int index2 = str2.length() - 1;
        while (index1 >= 0 || index2 >= 0) {
            int i1 = getNextValidIndex(str1, index1);
            int i2 = getNextValidIndex(str2, index2);

            if (i1 < 0 && i2 < 0) { // reached end of both the string
                return true;
            }
            if (i1 < 0 || i2 < 0) { // reached end either of the string
                return false;
            }
            if (str1.charAt(i1) != str2.charAt(i2)) { // if characters not equal
                return false;
            }
            // Now, i1 and i2 are at valid character position. to compute next decrement by 1
            index1 = i1 - 1;
            index2 = i2 - 1;
        }
        return true;
    }

    private static int getNextValidIndex(String str, int index) {
        int backSpaceCount = 0;
        while(index >= 0){
            if(str.charAt(index) == '#'){ // found backspace character
                backSpaceCount++;
            } else if(backSpaceCount > 0){ // non-backspace character
                backSpaceCount--;
            } else {
                break; // already valid character
            }
            index--;
        }
        return index;
    }
}
