package trees;

public class MinDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(minDepth(root));
    }

    private static int minDepth(TreeNode root){
        if(root == null)
            return 0;
        if(root.left ==  null && root.right == null){
            return 1;
        }
        int lc = root.left !=  null ? minDepth(root.left): Integer.MAX_VALUE;
        int rc = root.right !=  null ? minDepth(root.right): Integer.MAX_VALUE;
        return 1 + Math.min(lc, rc);
    }
}
