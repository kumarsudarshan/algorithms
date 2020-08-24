package recursion;

import java.util.HashMap;

public class PrintAllSequence {

    public static void main(String[] args) {
        print("abcd", "");
    }

    static void print(String input, String output){
        if(input.length() == 0){
            System.out.println(output);
            return;
        }
        print(input.substring(1), output + input.charAt(0));
        print(input.substring(1), output);
    }
}
