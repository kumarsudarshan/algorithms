package trees;


public class InsertInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(checkBST(root));
        inOrder(root);
        insertBSTRecursive(root, 1);
        insertBSTIterative(root, 4);
        System.out.println(checkBST(root));
        inOrder(root);
    }

    static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + "\t");
            inOrder(root.right);
        }
    }

    private static TreeNode insertBSTRecursive(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        } else {
            if (data < root.val) {
                root.left = insertBSTRecursive(root.left, data);
            } else {
                root.right = insertBSTRecursive(root.right, data);
            }
        }
        return root;
    }

    private static TreeNode insertBSTIterative(TreeNode root, int data) {
        TreeNode newNode = new TreeNode(data);
        if(root == null){
            return newNode;
        }
        TreeNode parent = null, current = root;
        while(current != null){
            parent = current;
            if(data < current.val){
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if(data < parent.val){
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        return root;
    }


    private static boolean checkBST(TreeNode root) {
        return checkBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkBSTHelper(TreeNode root, int minValue, int maxValue) {
        if (root == null)
            return true;
        if (root.val < minValue || root.val > maxValue)
            return false;
        return checkBSTHelper(root.left, minValue, root.val - 1) && checkBSTHelper(root.right, root.val + 1, maxValue);
    }
}
