package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
Clone a Binary Tree with Random Pointers
https://www.geeksforgeeks.org/clone-binary-tree-random-pointers/

 */
public class CloneBinaryTree {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(5);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(8);
        root.left.left = new BinaryTree(1);
        root.left.right = new BinaryTree(3);
        root.random = root.left.right;

        inOrder(root);
        System.out.println();

        BinaryTree cloned1 = cloneBFS(root);
        inOrder(cloned1);
        System.out.println();

        BinaryTree cloned2 = cloneDFS(root);
        inOrder(cloned2);
    }

    public static void inOrder(BinaryTree root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println("[" + root.val + " : " + (root.random != null ? root.random.val : root.random) + "]");
            inOrder(root.right);
        }
    }

    public static BinaryTree cloneBFS(BinaryTree root) {
        // edge case
        if (root == null) {
            return null;
        }

        // Normal case
        Map<BinaryTree, BinaryTree> map = new HashMap<>();
        map.put(root, new BinaryTree(root.val));
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree node = queue.poll();
            BinaryTree newNode = map.get(node);
            if (node.random != null) {
                if (!map.containsKey(node.random)) {
                    map.put(node.random, new BinaryTree(node.random.val));
                }
                newNode.random = map.get(node.random);
            }
            if (node.left != null) {
                if (!map.containsKey(node.left)) {
                    map.put(node.left, new BinaryTree(node.left.val));
                }
                newNode.left = map.get(node.left);
                queue.add(node.left);
            }
            if (node.right != null) {
                if (!map.containsKey(node.right)) {
                    map.put(node.right, new BinaryTree(node.right.val));
                }
                newNode.right = map.get(node.right);
                queue.add(node.right);
            }
        }
        return map.get(root);
    }

    static HashMap<BinaryTree, BinaryTree> map = new HashMap<>();

    public static BinaryTree cloneDFS(BinaryTree root) {
        // corner case
        if (root == null) {
            return null;
        }

        // normal case
        if (map.containsKey(root)) {
            return map.get(root);
        }

        BinaryTree copy = new BinaryTree(root.val);
        map.put(root, copy);

        copy.left = cloneDFS(root.left);
        copy.right = cloneDFS(root.right);
        copy.random = cloneDFS(root.random);

        return copy;
    }

}


class BinaryTree {
    int val;
    BinaryTree left;
    BinaryTree right;
    BinaryTree random;

    BinaryTree(int val) {
        this.val = val;
    }
}
