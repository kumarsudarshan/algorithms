package Trees;

public class BST {

	public static void main(String[] args) {
		BinaryTreeNode root = insertRecursive(null, 50);
		root = insertRecursive(root, 20);
		root = insertRecursive(root, 10);
		root = insertRecursive(root, 30);
		root = insertRecursive(root, 40);
		root = insertRecursive(root, 80);
		root = insertRecursive(root, 60);
		root = insertRecursive(root, 90);
		root = insertRecursive(root, 110);

		BinaryTreeTraversalRecursion.traverseBinaryTree(root);

		root = insertIterative(null, 50);
		root = insertIterative(root, 20);
		root = insertIterative(root, 10);
		root = insertIterative(root, 30);
		root = insertIterative(root, 40);
		root = insertIterative(root, 80);
		root = insertIterative(root, 60);
		root = insertIterative(root, 90);
		root = insertIterative(root, 110);

		BinaryTreeTraversalRecursion.traverseBinaryTree(root);

		System.out.println();
		System.out.println(isBST(root));

		System.out.println();
		System.out.println(nLargest(root, 3).getData());
		
		int[] arr = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		root = createBalancedBST(arr, 0, 8);
		
		BinaryTreeTraversalRecursion.traverseBinaryTree(root);
		
		System.out.println();
		System.out.println(lca(root, 99, 66).getData());
		System.out.println(lca(root, 22, 44).getData());
		System.out.println(lca(root, 33, 66).getData());

	}

	static BinaryTreeNode insertRecursive(BinaryTreeNode root, int val) {
		if (root == null) {
			return new BinaryTreeNode(val);
		}
		if (root.getData() >= val) {
			root.setLeft(insertRecursive(root.getLeft(), val));
		} else {
			root.setRight(insertRecursive(root.getRight(), val));
		}
		return root;
	}

	static BinaryTreeNode insertIterative(BinaryTreeNode root, int val) {
		BinaryTreeNode newNode = new BinaryTreeNode(val);
		if (root == null) {
			return newNode;
		}
		BinaryTreeNode parent = null, current = root;
		while (current != null) {
			parent = current;
			current = current.getData() >= val ? current.getLeft() : current.getRight();
		}
		if (parent.getData() >= val) {
			parent.setLeft(newNode);
		} else {
			parent.setRight(newNode);
		}
		return root;
	}

	static boolean isBST(BinaryTreeNode root) {
		return isBSTHelperMethod(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBSTHelperMethod(BinaryTreeNode root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		if (root.getData() < minValue && root.getData() > maxValue) {
			return false;
		} else {
			return isBSTHelperMethod(root.getLeft(), minValue, root.getData() - 1)
					&& isBSTHelperMethod(root.getRight(), root.getData() + 1, maxValue);
		}
	}

	static int totalVisited = 0;
	static BinaryTreeNode nlarge = null;

	static BinaryTreeNode nLargest(BinaryTreeNode root, int n) {
		if (root == null) {
			return root;
		}
		nLargest(root.getRight(), n);

		totalVisited++;
		if (totalVisited == n) {
			nlarge = root;
			return root;
		}

		nLargest(root.getLeft(), n);
		return nlarge;
	}

	static BinaryTreeNode createBalancedBST(int[] arr, int start, int end) {
		if (arr.length == 0 || start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		BinaryTreeNode root = new BinaryTreeNode(arr[mid]);
		root.setLeft(createBalancedBST(arr, start, mid - 1));
		root.setRight(createBalancedBST(arr, mid + 1, end));
		return root;
	}
	
	static BinaryTreeNode lca(BinaryTreeNode root, int n1, int n2) {
		if(root == null) 
			return null;
		if(root.getData() > n1 && root.getData() > n2) {
			return lca(root.getLeft(), n1, n2);
		}
		if(root.getData() < n1 && root.getData() < n2) {
			return lca(root.getRight(), n1, n2);
		}
		return root;
	}

}
