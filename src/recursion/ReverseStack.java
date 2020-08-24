package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(300);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }

    static void reverse(Stack<Integer> stack) {
        if(stack.size() <= 1)
            return;
        int temp = stack.pop();
        reverse(stack);
        stack.add(0, temp); // not recommended -- try to write own insert at last.
    }




}
