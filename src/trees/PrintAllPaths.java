package trees;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, print all root-to-leaf paths
https://www.geeksforgeeks.org/given-a-binary-tree-print-all-root-to-leaf-paths/
/* Constructed binary tree is
            10
          /   \
        8      2
      /  \    /
    3     5  2
All root-to-leaf paths are:
10 –> 8 –> 3
10 –> 8 –> 5
10 –> 2 –> 2
 */
public class PrintAllPaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        printAllPaths(root, new ArrayList<>());
    }

    public static void printAllPaths(TreeNode root, List<Integer> paths) {
        if (root == null) {
            return;
        }
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            System.out.println(paths);
        }
        printAllPaths(root.left, paths);
        printAllPaths(root.right, paths);
        paths.remove(paths.size() - 1);
    }
}
