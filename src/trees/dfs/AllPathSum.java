package trees.dfs;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println(allPathCount(root, 12)); // 2 (1->7->4) and (1->9->2)
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        allPaths(root, 12, currentPath, result);
        System.out.println(result); // [[1, 7, 4], [1, 9, 2]]

    }

    public static int allPathCount(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return 1;
        }
        return allPathCount(root.left, sum - root.val) + allPathCount(root.right, sum - root.val);
    }

    public static void allPaths(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        // add the current node to the path
        currentPath.add(root.val);
        // if current node is leaf and value eqaul to sum then save the current path.
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<>(currentPath));
        }
        allPaths(root.left, sum - root.val, currentPath, result);
        allPaths(root.right, sum - root.val, currentPath, result);

        // remove the current node from the path to backtrack
        // we need to remove the current node while we are going up in the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }
}
