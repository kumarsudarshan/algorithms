package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
//
//        For example, given the string "([])[]({})", you should return true.
//
//        Given the string "([)]" or "((()", you should return false.


public class BalancedBrackets {

    public static void main(String[] args) {
        System.out.println(isBalanced("([])[]({})"));
        System.out.println(isBalanced("([)]"));
        System.out.println(isBalanced("((()"));
    }

    private static boolean isBalanced(String str){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('(', 1);
        map.put(')', -1);
        map.put('{', 2);
        map.put('}', -2);
        map.put('[', 3);
        map.put(']', -3);
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < str.length();i++){
            if(!stack.isEmpty() && (stack.peek() + map.get(str.charAt(i))) == 0){
                stack.pop();
                continue;
            }
            stack.push(map.get(str.charAt(i)));
        }
        return stack.isEmpty();
    }

}
