package tryer.tree.bst;

import tryer.tree.Tree;

//wtf DIAGNOSIS - SHIT
public class BST implements Tree {

    Node root;

    public BST(int... values) {
        for (int i = 0; i < values.length; i++) {
            this.insert(values[i]);
        }
    }

    @Override
    public void insert(int value) {
        if (null == root) {
            root = new Node(value);
/*
            //todo special case for root
            Node dummy = new Node(-1);
            dummy.left = root;
            dummy.right = root;
            root.parent = dummy;
*/
            return;
        }

        Node current = root;
        while (null != current) {
            if (value <= current.value) {
                if (null == current.left) {
                    Node newNode = new Node(value);
                    newNode.parent = current;
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else {
                if (null == current.right) {
                    Node newNode = new Node(value);
                    newNode.parent = current;
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }
        }
    }

    @Override
    public void remove(int value) { // todo - reference leaking through not null patent in the removed node, parent nodes are not updated
        Node current = root;
        while (null != current) {

            if (current.value == value) {
                if (null == current.left && null == current.right) {
                    Node parent = current.parent;
                    if (parent.left == current) parent.left = null;
                    else parent.right= null;
                    return;
                }
                if (null != current.left && null == current.right) {
                    Node parent = current.parent;
                    if (parent.left == current) parent.left = current.left;
                    else parent.right = current.left;
                    return;
                }
                if (null == current.left && null != current.right) {
                    Node parent = current.parent;
                    if (parent.left == current) parent.left = current.right;
                    else parent.right = current.right;
                    return;
                }
                if (null != current.left && null != current.right) {
                    Node toReplace = current.left;
                    if (toReplace.right != null) {
                        while (toReplace.right != null)
                            toReplace = toReplace.right;
                        toReplace.parent.right = null;
                    } else {
                        toReplace.parent.left = null;
                    }
                    Node parent = current.parent;
                    if (parent.left == current) parent.left = toReplace;
                    else parent.right = toReplace;
                    toReplace.parent = current.parent;
                    toReplace.right = current.right;
                    toReplace.left = current.left;
                    return;
                }
            }
            if (value <= current.value) current = current.left;
            else current = current.right;
        }
    }

    @Override
    public boolean contains(int value) {
        return containsIterative(value);
    }

    private boolean containsRecursive(int value, Node node) {
        if (null == node)
            return false;
        if (node.value == value)
            return true;
        if (value <= node.value)
            return containsRecursive(value, node.left);
        else
            return containsRecursive(value, node.right);
    }

    private boolean containsIterative(int value) {
        Node current = root;
        while (null != current) {
            if (current.value == value)
                return true;
            if (value <= current.value)
                current = current.left;
            else
                current = current.right;
        }
        return false;
    }

    @Override
    public void printInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node node) {
        if (null == node) return;
        traverseInOrder(node.left);
        System.out.print(node.value);
        System.out.print(" ");
        traverseInOrder(node.right);
    }

    public void leftRotateOn(int value) {
        Node initParent = firstEncounter(value);
        if (null == initParent) return;
        Node newParent = initParent.right;
        if (null == newParent) return;

        Node grandParent = initParent.parent;
        newParent.parent = grandParent;
        if (grandParent.left == initParent) grandParent.left = newParent;
        else grandParent.right = newParent;
        initParent.parent = newParent;

        initParent.right = newParent.left;
        initParent.left.parent = initParent;

        newParent.left = initParent;
    }

    @Override
    public void rightRotateOn(int value) {
        Node initParent = firstEncounter(value);
        if (null == initParent) return;
        Node newParent = initParent.left;
        if (null == newParent) return;

        Node grandParent = initParent.parent;
        newParent.parent = grandParent;
        if (grandParent.right == initParent) grandParent.right = newParent;
        else grandParent.left = newParent;
        initParent.parent = newParent;

        initParent.left = newParent.right;
        newParent.right.parent = initParent;

        newParent.right = initParent;
    }

    @Override
    public int[] traverseInOrder() {
        return new int[0];
    }

    @Override
    public int getSize() {
        return 0;
    }

    private Node firstEncounter(int value) {
        Node current = root;
        while (null != current) {
            if (value == current.value) break;
            if (value <= current.value)
                current = current.left;
            else
                current = current.right;
        }
        return current;
    }


}

class Node {
    Node parent;
    Node left;
    Node right;
    int value;

    public Node (int value) {
        this.value = value;
    }
}
