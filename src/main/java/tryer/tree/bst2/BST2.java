package tryer.tree.bst2;

import tryer.tree.Tree;

import java.util.LinkedList;
import java.util.List;

//wtf DIAGNOSIS FUCKING SHIT, but so-so
public class BST2 implements Tree {

    Node root;
    int size = 0;

    public BST2(int... values) {
        for (int i = 0; i < values.length; i++) {
            this.insert(values[i]);
        }
    }

    public boolean contains(int key) {
        Node current = root;
        while (current != null) {
            if (current.value == key) return true;
            if (current.value > key) current = current.left;
            else current = current.right;
        }
        return false;
    }

    @Override
    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (null == node) return;
        printInOrder(node.left);
        System.out.print(node.value);
        System.out.print(" ");
        printInOrder(node.right);
    }

    @Override
    public void leftRotateOn(int value) {

    }

    @Override
    public void rightRotateOn(int value) {

    }

    @Override
    public int[] traverseInOrder() {
        List<Integer> valuesSet = new LinkedList<>();
        traverseInOrder(root, valuesSet);

        return valuesSet.stream().mapToInt(i->i).toArray();
    }

    private void traverseInOrder(Node node, List<Integer> result) {
        if (node == null) return;

        traverseInOrder(node.left, result);
        result.add(node.value);
        traverseInOrder(node.right, result);
    }

    @Override
    public int getSize() {
        return size;
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            size++;
            return;
        }

        Node current = root;
        while (current != null) {
            if (current.value > key) {
                if (current.left != null) {
                    current = current.left;
                    continue;
                }
                current.left = new Node(key);
                size++;
                return;
            }
            if (current.value < key) {
                if (current.right != null) {
                    current = current.right;
                    continue;
                }
                current.right = new Node(key);
                size++;
                return;
            }
            if (current.value == key) return;
        }
    }

    public void remove(int key) {
        if (root == null) return;

        Node parent = null;
        Node current = root;
        Boolean isLeftChild = null;
        do {
            if (current.value == key) {
                if (parent == null) {
                    deleteRoot();
                    size--;
                } else if (isLeftChild) {
                    deleteLeftChild(parent);
                    size--;
                } else {
                    deleteRightChild(parent);
                    size--;
                }
                return;
                }
                if (current.value > key) {
                    parent = current;
                    current = parent.left;
                    isLeftChild = true;
                } else {
                    parent = current;
                    current = parent.right;
                    isLeftChild = false;
                }
            } while (current != null);
        }

        private void deleteLeftChild(Node parent) {
            Node toRemove = parent.left;
            Node leftGChild = toRemove.left;
            Node rightGChild = toRemove.right;
            if (leftGChild == null && rightGChild == null) {
                parent.left = null;
            } else if (leftGChild != null && rightGChild == null) {
                parent.left = leftGChild;
            } else if (leftGChild == null && rightGChild != null) {
                parent.left = rightGChild;
            } else {

                Node replacementParent = toRemove;
                Node replacement = toRemove.left;
                while (replacement.right != null) {
                    replacementParent = replacement;
                    replacement = replacement.right;
                }

                if (replacement == leftGChild) {
                    parent.left = leftGChild;
                    leftGChild.right = rightGChild;
                } else {
                    replacementParent.right = replacement.left;
                    replacement.left = null;
                    parent.left = replacement;
                    replacement.left = leftGChild;
                    replacement.right = rightGChild;
                }
                toRemove.left = null; toRemove.right = null;
            }
        }

        private void deleteRightChild(Node parent) {
            Node toRemove = parent.right;
            Node leftGChild = toRemove.left;
            Node rightGChild = toRemove.right;
            if (leftGChild == null && rightGChild == null) {
                parent.right = null;
            } else if (leftGChild != null && rightGChild == null) {
                parent.right = leftGChild;
            } else if (leftGChild == null && rightGChild != null) {
                parent.right = rightGChild;
            } else {

                Node replacementParent = toRemove;
                Node replacement = toRemove.left;
                while (replacement.right != null) {
                    replacementParent = replacement;
                    replacement = replacement.right;
                }

                if (replacement == leftGChild) {
                    parent.right = leftGChild;
                    leftGChild.right = rightGChild;
                } else {
                    replacementParent.right = replacement.left;
                    replacement.left = null;
                    parent.right = replacement;
                    replacement.left = leftGChild;
                    replacement.right = rightGChild;
                }
                toRemove.left = null; toRemove.right = null;
            }
        }

        private void deleteRoot() {
            Node toRemove = root;
            Node leftGChild = toRemove.left;
            Node rightGChild = toRemove.right;
            if (leftGChild == null && rightGChild == null) {
                root = null;
            } else if (leftGChild != null && rightGChild == null) {
                root = leftGChild;
            } else if (leftGChild == null && rightGChild != null) {
                root = rightGChild;
            } else {

                Node replacementParent = toRemove;
                Node replacement = toRemove.left;
                while (replacement.right != null) {
                    replacementParent = replacement;
                    replacement = replacement.right;
                }

                if (replacement == leftGChild) {
                    root = leftGChild;
                    leftGChild.right = rightGChild;
                } else {
                    replacementParent.right = replacement.left;
                    replacement.left = null;
                    root = replacement;
                    replacement.left = leftGChild;
                    replacement.right = rightGChild;
                }
                toRemove.left = null; toRemove.right = null;
            }
        }
    }


    class Node {
        int value;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
