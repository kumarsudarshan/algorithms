package trees.dfs;

import trees.TreeNode;

public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(hasPath(root, 10)); // true - 1 -> 3 -> 6
    }

    public static boolean hasPath(TreeNode root, int sum){
        if(root == null){
            return false;
        } else if(root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }
}
