package Trees;

public class LCABinaryTree {

	public static void main(String args[]) {
		BinaryTreeNode root = BinaryTree.createBinaryTree();
        BinaryTreeTraversalRecursion.traverseBinaryTree(root);
        
        System.out.println();
        System.out.println(lca(root, 5, 6).getData());
    }
    
	static BinaryTreeNode lca(BinaryTreeNode root, int n1, int n2) {
		if(root == null || root.getData() == n1 || root.getData() == n2) 
			return root;
		BinaryTreeNode leftTree = lca(root.getLeft(), n1, n2);
		BinaryTreeNode rightTree = lca(root.getRight(), n1, n2);
		
		if(leftTree != null && rightTree != null) {
			return root;
		} else if(leftTree != null) {
			return leftTree;
		} else {
			return rightTree;
		}
	}
	
}
