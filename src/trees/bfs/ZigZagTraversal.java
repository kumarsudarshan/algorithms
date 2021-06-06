package trees.bfs;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(doBFS(root)); // [[1], [3, 2], [4, 5, 6, 7]]
    }

    public static List<List<Integer>> doBFS(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> currentLevel = new ArrayList<>(level);
            for(int i = 0; i < level; i++){ // traverse all nodes of that level
                TreeNode currentNode = queue.poll();
                if(leftToRight){ // change the order of insertion at level wise
                    currentLevel.add(currentNode.val);
                } else {
                    currentLevel.add(0, currentNode.val);
                }

                // push children's to the queue if exists
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }
        return result;
    }
}
