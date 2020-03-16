package tryer.tree.treetraversal;

public class Tree {

    Node root;

    public Tree() {
        root = new Node(0);

        root.left = new Node(1);
        root.left.left = new Node(2);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);

        root.right = new Node(4);
        root.right.right = new Node(5);
        root.right.right.left = new Node(6);
        root.right.right.left.right = new Node(7);
        root.right.right.left.right.left = new Node(9);
        root.right.right.left.right.right = new Node(8);
    }

}

class Node {

    public Node(int value) {
        this.value = value;
    }

    int value;
    Node left;
    Node right;
}



