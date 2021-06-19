package trees;

import java.util.*;

public class SerializeDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        inorder(root);
        System.out.println();
        System.out.println(serialize(root));

        root = deserialize(serialize(root));
        inorder(root);
    }

    public static String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        List<String> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top == null) {
                list.add("#");
            } else {
                list.add("" + top.val);
                stack.push(top.right);
                stack.push(top.left);
            }
        }
        return String.join(",", list);
    }

    static int t;

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null)
            return null;
        t = 0;
        String[] arr = data.split(",");
        return helper(arr);
    }

    public static TreeNode helper(String[] arr) {
        if (arr[t].equals("#"))
            return null;
        // create node with this item and recur for children
        TreeNode root
                = new TreeNode(Integer.parseInt(arr[t]));
        t++;
        root.left = helper(arr);
        t++;
        root.right = helper(arr);
        return root;
    }

    // A simple inorder traversal used for testing the
    // constructed tree
    static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "NULL ";
        }
        return (root.val + " ") + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    private int index = 0;
    public TreeNode deserialize(String data) {
        List<String> list = Arrays.asList(data.split(" "));
        index = 0;
        return deserializeHelper(list);
    }

    private TreeNode deserializeHelper(List<String> list){
        if(index >= list.size() || list.get(index).equals("NULL")){
            return null;
        }
        Integer val = Integer.valueOf(list.get(index));
        TreeNode node = new TreeNode(val);
        index++;
        node.left = deserializeHelper(list);

        index++;
        node.right = deserializeHelper(list);
        return node;
    }
}