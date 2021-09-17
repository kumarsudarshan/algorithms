package trees;

public class IntervalTree {
    public static void main(String[] args) {
        IntervalTreeNode root = new IntervalTreeNode(10, 20);
        insert(root, 5, 50);
        inOrder(root);
    }

    public static IntervalTreeNode insert(IntervalTreeNode root, int low, int high){
        if(root == null) {
            return new IntervalTreeNode(low, high);
        }
        int l = root.low;
        if(low < l) {
            root.left = insert(root.left, low, high);
        } else {
            root.right = insert(root.right, low, high);
        }
        if(root.max < high) {
            root.max = high;
        }
        return root;
    }

    public static void delete(int low, int high){

    }

    public static boolean search(int key) {
        return false;
    }

    public static void inOrder(IntervalTreeNode root){
        if(root != null) {
            inOrder(root.left);
            System.out.println("[" + root.low + ", " + root.high + "]");
            inOrder(root.right);
        }
    }

}

class IntervalTreeNode {
    int low;
    int high;
    int max = Integer.MIN_VALUE;
    IntervalTreeNode left;
    IntervalTreeNode right;

    public IntervalTreeNode(int low, int high) {
        this.low = low;
        this.high = high;
        max = Math.max(max, high);
    }
}