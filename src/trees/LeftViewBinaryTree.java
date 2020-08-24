package trees;


//Print Left View of a Binary Tree
//        Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from left side.
//
//        left-view
//
//        Examples:
//
//        Input :
//          1
//        /   \
//        2     3
//        / \     \
//        4   5     6
//        Output : 1 2 4
//
//        Input :
//          1
//        /   \
//        2     3
//         \
//          4
//           \
//            5
//             \
//              6
//        Output :1 2 4 5 6
//  https://www.geeksforgeeks.org/print-left-view-binary-tree/

public class LeftViewBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        leftView(root);
    }

    private static void leftView(TreeNode root){
        leftViewHelper(root, 0);
    }
    static int levelTouched = -1;
    private static void leftViewHelper(TreeNode root, int level){
        if(root != null) {
            if(levelTouched < level) {
                System.out.println(root.val);
                levelTouched = level;
            }
            leftViewHelper(root.left, level + 1);// reverse the order will get right view
            leftViewHelper(root.right, level + 1);
        }
    }

}


