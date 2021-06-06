package trees.bfs;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        System.out.println(rightView(root)); // [1, 3, 7, 8]
    }

    public static List<Integer> rightView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            int lastNodeOfLevel = 0;
            for(int i = 0; i < level; i++){ // traverse all nodes of that level
                TreeNode currentNode = queue.poll();
                lastNodeOfLevel = currentNode.val;
                // push children's to the queue if exists
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
            result.add(lastNodeOfLevel);
        }
        return result;
    }
}
