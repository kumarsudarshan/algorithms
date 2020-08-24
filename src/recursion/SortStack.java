package recursion;

import java.util.ArrayList;
import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(10);
        stack.add(5);
        stack.add(15);
        stack.add(1);
        stack.add(0);
        stack.add(2);
        stack.add(17);
        System.out.println(stack);
        sort(stack);
        System.out.println(stack);
    }

    static void sort(Stack<Integer> stack){
        if(stack.size() <= 1){
            return;
        }
        int temp = stack.get(stack.size() - 1);
        stack.remove(stack.size()-1);
        sort(stack);
        insert(stack, temp);
    }

    private static void insert(Stack<Integer> stack, int temp) {
        if(stack.size() == 0 || stack.get(stack.size()-1) <= temp){
            stack.add(temp);
            return;
        }
        int val = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        insert(stack, temp);
        stack.add(val);
    }
}
