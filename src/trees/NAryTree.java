package trees;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Given a csv file where each row containing country,state,district
for example:
india,karnataka,bangalore
india,karnataka,mysore
india,maharastra,mumbai
usa,nevada,xyz

We need to build tree based on that rows
                        india                               usa
                    /           \                               \
         karnataka               maharastra                     nevada
       /         \                      \                            \
bangalore        mysore                 mumbai                       xyz
 */
public class NAryTree {

    public static void main(String[] args) {
        Node root = insertAllNodes();
        traverse(root);
    }

    public static void traverse(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.println(currentNode.name);
            if (currentNode.child != null) {
                for (Node node : currentNode.child) {
                    queue.add(node);
                }
            }
        }
    }

    public static Node insertAllNodes() {
        Node root = new Node("");
        root.child = new ArrayList<>();
        List<String> rowsList = getRows();
        for (String row : rowsList) {
            String[] list = row.split(",");
            insert(root, "", new Node(list[0]));
            insert(root, list[0], new Node(list[1]));
            insert(root, list[1], new Node(list[2]));
        }
        return root;
    }

    static void insert(Node root, String parent, Node node) {
        if (root.name.equals(parent)) {
            List<Node> child = root.child;
            for (Node nodeList : child) {
                if (nodeList.name.equals(node.name)) {
                    return;
                }
            }
            root.child.add(node);
            return;
        }
        int size = root.child.size();
        for (int i = 0; i < size; i++) {
            if (root.child.get(i).name.equals(parent)) {
                insert(root.child.get(i), parent, node);
            } else {
                int childSize = root.child.get(i).child.size();
                for (int j = 0; j < childSize; j++) {
                    if(root.child.get(i).child.get(j).name.equals(parent)){
                        insert(root.child.get(i).child.get(j), parent, node);
                    }
                }
            }
        }
    }

    public static List<String> getRows() {
        List<String> rowsList = new ArrayList<>();
        rowsList.add("india,karnataka,bangalore");
        rowsList.add("india,karnataka,mangalore");
        rowsList.add("india,karnataka,mysore");
        rowsList.add("india,maharastra,mumbai");
        rowsList.add("india,maharastra,nagpur");
        rowsList.add("india,gujrat,gandhinagar");
        rowsList.add("usa,nevada,xyz");
        return rowsList;
    }
}

class Node {
    String name;
    List<Node> child;

    public Node(String name) {
        this.name = name;
        this.child = new ArrayList<>();
    }
}