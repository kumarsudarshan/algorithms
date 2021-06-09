package subset;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Structurally Unique Binary Search Trees (hard)
Given a number ‘n’, write a function to return all structurally unique Binary Search Trees (BST) that can store values 1 to ‘n’?

Input: 2
Output: 2
Explanation: Here are all the structurally unique BSTs storing all numbers from 1 to 2:
 */

public class UniqueBST {
    public static void main(String[] args) {
        System.out.println(findUniqueTrees(2).size()); // 2
        System.out.println(findUniqueTrees(3).size()); // 5
    }

    public static List<TreeNode> findUniqueTrees(int n){
        if(n <= 0){
            return new ArrayList<>();
        }
        return findUniqueTreesRecursive(1, n);
    }

    public static List<TreeNode> findUniqueTreesRecursive(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        // base condition, return null for empty sub-tree
        // consider n = 1, in this case, we will have start=end=1, this means we should have only one tree
        // we will have two recursive calls, findUniqueTreesRecursive(1, 0) and (2, 1)
        // both of these two return null for the left and the right child.
        if(start > end){
            result.add(null);
            return result;
        } else {
            for(int i = start; i <= end; i++){
                // making i as root of the tree.
                List<TreeNode> leftSubTrees = findUniqueTreesRecursive(start, i - 1);
                List<TreeNode> rightSubTrees = findUniqueTreesRecursive(i + 1, end);
                for(TreeNode leftSubTree : leftSubTrees){
                    for(TreeNode rightSubTree : rightSubTrees){
                        TreeNode root = new TreeNode(i);
                        root.left = leftSubTree;
                        root.right = rightSubTree;
                        result.add(root);
                    }
                }
            }
        }
        return result;
    }
}
