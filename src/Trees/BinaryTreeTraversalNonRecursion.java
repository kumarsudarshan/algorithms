package Trees;

import java.util.Stack;

public class BinaryTreeTraversalNonRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void traverseBinaryTree(BinaryTreeNode root) {
		System.out.println("\nPreOrder Traversal : ");
		BinaryTreeTraversalNonRecursion.preOrderTraveral(root);
		System.out.println("\nInOrder Traversal : ");
		BinaryTreeTraversalNonRecursion.inOrderTraveral(root);
		System.out.println("\nPostOrder Traversal : ");
		BinaryTreeTraversalNonRecursion.postOrderTraveral(root);
	}

	static void preOrderTraveral(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		if (root == null) {
			return;
		}
		stack.push(root);
		while (!stack.isEmpty()) {

			BinaryTreeNode top = stack.pop();
			System.out.print("\t" + top.getData());

			// maintain sequence here
			if (top.getRight() != null) {
				stack.push(top.getRight());
			}
			if (top.getLeft() != null) {
				stack.push(top.getLeft());
			}
		}
	}

	static void inOrderTraveral(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode currentNode = root;
		boolean done = false;

		while (!done) {
			if (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			} else {
				if (stack.isEmpty()) {
					done = true;
				} else {
					currentNode = stack.pop();
					System.out.print("\t" + currentNode.getData());
					currentNode = currentNode.getRight();
				}
			}

		}
	}

	static void postOrderTraveral(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		if (root == null) {
			return;
		}
		stack.push(root);
		BinaryTreeNode prevNode = null;
		while (!stack.isEmpty()) {
			BinaryTreeNode currentNode = stack.peek();
			if (prevNode == null || prevNode.getLeft() == currentNode || prevNode.getRight() == currentNode) {
				if(currentNode.getLeft() != null) {
					stack.push(currentNode.getLeft());
				}
				else if(currentNode.getRight() != null) {
					stack.push(currentNode.getRight());
				}
			} 
			else if (currentNode.getLeft() == prevNode) {
				if(currentNode.getRight() != null)
                    stack.push(currentNode.getRight());
			} else {
				System.out.print("\t" + currentNode.getData());
				stack.pop();
			}
			prevNode = currentNode;
		}
	}

}
