package recursion;

import java.util.Stack;

public class DeleteMiddleInStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        System.out.println(stack);
        deleteMiddle(stack, (stack.size()/2)+1);
        System.out.println(stack);
    }

    // delete middle element in stack.
    static void deleteMiddle(Stack<Integer> stack, int k){
        if(k == 1){
            stack.pop();
            return;
        }
        int temp = stack.pop();
        deleteMiddle(stack, k-1);
        stack.push(temp);
    }
}
