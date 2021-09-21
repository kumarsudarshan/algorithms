package trees;

/*
https://www.geeksforgeeks.org/check-whether-bst-contains-dead-end-not/
Check whether BST contains Dead End or not
Given a Binary search Tree that contains positive integer values greater than 0.
The task is to check whether the BST contains a dead end or not. Here Dead End means,
 we are not able to insert any element after that node.

Input :        8
             /   \
           5      9
         /   \
        2     7
       /
      1
Output : Yes
Explanation : Node "1" is the dead End because
         after that we cant insert any element.

Input :       8
            /   \
           7     10
         /      /   \
        2      9     13

Output : Yes
Explanation : We can't insert any element at
              node 9.
 */
public class DeadEndBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(13);
        System.out.println(isDeadEnd(root));
    }

    public static boolean isDeadEnd(TreeNode root) {
        return isDeadEndUtil(root, 0, Integer.MAX_VALUE);
    }

    public static boolean isDeadEndUtil(TreeNode root, int left, int right) {
        if (root == null){
            return false;
        }
        if (right - left == 2){
            return true;
        }

        return isDeadEndUtil(root.left, left, root.val) || isDeadEndUtil(root.right, root.val, right);
    }
}

