package trees;

// Print Bottom View of a Binary Tree
//        Given a Binary Tree, print bottom view of it.
//
//        Examples:
//
//        Input :
//          1
//        /   \
//       2     3
//      / \     \
//     4   5     6
//           \
//             7
//   Output : 4, 2, 5, 7, 6
//

import java.util.Map;
import java.util.TreeMap;

public class BottomViewBinaryTree {
    static TreeMap<Integer, Pair> tm = new TreeMap<Integer, Pair>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.right= new TreeNode(7);
        root.left.left = new TreeNode(4);
        bottomView(root);
        for (Map.Entry<Integer, Pair> entry : tm.entrySet())
            System.out.print(entry.getValue().b + "\t");
    }

    private static void bottomView(TreeNode root){
        bottomViewHelper(root, 0, 0);
    }

    private static void bottomViewHelper(TreeNode root, int vLevel, int hLevel){
        if(root != null) {
            if(tm.containsKey(vLevel)){
                Pair p = tm.get(vLevel);
                if(hLevel > p.a){ // change the order will get top view
                    tm.put(vLevel, new Pair(hLevel, root.val));
                }
            } else{
                tm.put(vLevel, new Pair(hLevel, root.val));
            }
            bottomViewHelper(root.left, vLevel - 1, hLevel + 1);
            bottomViewHelper(root.right, vLevel + 1, hLevel + 1);
        }
    }

}

class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}