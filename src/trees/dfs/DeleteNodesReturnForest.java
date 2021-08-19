package trees.dfs;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Delete Nodes And Return Forest
https://medium.com/algorithm-and-datastructure/delete-nodes-and-return-forest-13ac20c5a601
Given the root of a binary tree, each node in the tree has a distinct value.
After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
Return the roots of the trees in the remaining forest. You may return the result in any order.

Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
                    1
                 /     \
                2       3
              /   \   /   \
             4    5  6     7
Output: [[1,2,null,4],[6],[7]]

 */
public class DeleteNodesReturnForest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        deleteNodes(root, new int[]{3, 5}).forEach(tree -> {
            inOrder(tree);
            System.out.println();
        });

    }

    public static void inOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "  ");
            inOrder(root.left);
            inOrder(root.right);
        }
    }

    public static List<TreeNode> deleteNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int de : to_delete) {
            set.add(de);
        }
        //put to-delete number in hashset for O(1) lookup
        doDFS(root, set, result, true);
        return result;
    }

    private static void doDFS(TreeNode root, Set<Integer> del, List<TreeNode> result, boolean isRoot) {
        //if current root does not contain in the del and it is root,
        // then add to the result
        if (!del.contains(root.val) && isRoot)
            result.add(root);

        // check parents is on the list of 'to_be_deleted'
        isRoot = del.contains(root.val);

        // As we are doing DFS, we need check left node and right node
        if (root.left != null) {
            doDFS(root.left, del, result, isRoot);
            // If the child node is on the 'to_be_deleted' list, replace it will null
            if (del.contains(root.left.val))
                root.left = null;
        }

        if (root.right != null) {
            doDFS(root.right, del, result, isRoot);
            // If the child node is on the 'to_be_deleted' list, replace it will null
            if (del.contains(root.right.val))
                root.right = null;
        }
    }

}
