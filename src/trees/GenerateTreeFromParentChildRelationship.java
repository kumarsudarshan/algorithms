package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a list of child->parent relationships, build a binary tree out of it.
All the element Ids inside the tree are unique.

Given the following relationships:

Child Parent IsLeft
15 20 true
19 80 true
17 20 false
16 80 false
80 50 false
50 null false
20 50 true

You should return the following tree:

    50
   /  \
  20   80
 / \   / \
15 17 19 16
 */
public class GenerateTreeFromParentChildRelationship {
    public static void main(String[] args) {
        List<Relation> nodeList = new ArrayList<>();
        nodeList.add(new Relation(15, 20, true));
        nodeList.add(new Relation(19, 80, true));
        nodeList.add(new Relation(17, 20, false));
        nodeList.add(new Relation(16, 80, false));
        nodeList.add(new Relation(80, 50, false));
        nodeList.add(new Relation(50, null, false));
        nodeList.add(new Relation(20, 50, true));
        TreeNode root = buildTree(nodeList);
        inOrder(root);
    }

    static int count = 0;

    public static TreeNode buildTree(List<Relation> nodeList) {
        Map<Integer, Map<Integer, Boolean>> parentChildListMap = new HashMap<>();
        Integer rootNode = null;
        for (Relation relation : nodeList) {
            if (relation.parent == null) {
                rootNode = relation.child;
            }
            Map<Integer, Boolean> temp = new HashMap<>();;
            if (parentChildListMap.containsKey(relation.parent)) {
                temp = parentChildListMap.get(relation.parent);
            }
            temp.put(relation.child, relation.isLeft);
            parentChildListMap.put(relation.parent, temp);
        }
        count = nodeList.size();
        if (rootNode == null) {
            return null;
        }
        TreeNode root = new TreeNode(rootNode);
        count--;
        buildTreeHelper(root, rootNode, parentChildListMap);
        return root;
    }

    private static void buildTreeHelper(TreeNode node, int parent, Map<Integer, Map<Integer, Boolean>> parentChildListMap) {
        if (count == 0) {
            return;
        }
        if (parentChildListMap.get(parent) != null) {
            for(Map.Entry<Integer, Boolean> entry : parentChildListMap.get(parent).entrySet()){
                if(entry.getValue()) { // if left
                    node.left = new TreeNode(entry.getKey());
                    buildTreeHelper(node.left, entry.getKey(), parentChildListMap);
                } else { // then right
                    node.right = new TreeNode(entry.getKey());
                    buildTreeHelper(node.right, entry.getKey(), parentChildListMap);
                }
            }
        }
        count++;
    }

    static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + "\t");
            inOrder(root.right);
        }
    }
}

class Relation {
    Integer parent;
    Integer child;
    boolean isLeft;

    public Relation(Integer child, Integer parent, boolean isLeft) {
        this.parent = parent;
        this.child = child;
        this.isLeft = isLeft;
    }
}