package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Binary Tree Level Order Traversal II
//
//        Solution
//        Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
//        For example:
//        Given binary tree [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its bottom-up level order traversal as:
//        [
//        [15,7],
//        [9,20],
//        [3]
//        ]
// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class LevelOrderTraversal2 {

    public static void main(String[] args) {
        // 0                5
        // 1            3       8
        // 2        2       4
        // 3    1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(20);

        System.out.println("Inorder - Recursive:- ");
        inorder(root);
        System.out.println(levelOrderBottom(root));

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderBottomHelper(root, 0, result);
        Collections.reverse(result);
        return result;
    }

    private static void levelOrderBottomHelper(TreeNode root, int level, List<List<Integer>> result) {
        if(root != null){
            if(result.size() > level){
                result.get(level).add(root.val);
            } else {
                List<Integer> element = new ArrayList<Integer>();
                element.add(root.val);
                result.add(element);
            }
            levelOrderBottomHelper(root.left, level + 1, result);
            levelOrderBottomHelper(root.right, level + 1, result);

        }
    }

    private static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + "    ");
            inorder(root.right);
        }
    }
}

