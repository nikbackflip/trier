package tryer.tree.treetraversal;

public class Traversal {

    public static Tree tree = new Tree();

    public static void preOrder(Node currentNode) {
        if (currentNode == null) return;
        System.out.print(currentNode.value + " ");
        preOrder(currentNode.left);
        preOrder(currentNode.right);
    }

    public static void inOrder(Node currentNode) {
        if (currentNode == null) return;
        inOrder(currentNode.left);
        System.out.print(currentNode.value + " ");
        inOrder(currentNode.right);
    }

    public static void postOrder(Node currentNode) {
        if (currentNode == null) return;
        postOrder(currentNode.left);
        postOrder(currentNode.right);
        System.out.print(currentNode.value + " ");
    }

    public static void main(String[] args) {

        System.out.println("preOrder:");
        preOrder(tree.root);
        System.out.println("\n");

        System.out.println("inOrder:");
        inOrder(tree.root);
        System.out.println("\n");

        System.out.println("postOrder:");
        postOrder(tree.root);
        System.out.println("\n");

    }

}
