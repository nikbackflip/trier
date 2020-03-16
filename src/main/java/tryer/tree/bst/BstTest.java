package tryer.tree.bst;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import org.junit.Assert;

public class BstTest {

    @Test
    public void buildSimple() {
        BST tree = new BST(1, 2, 3, 4, 5);

        tree.printInOrder();

        Assert.assertTrue(isBST(tree));
    }

    @Test
    public void buildWithRandomElements() {
        int[] values = new int[]{58, -40 , 17 , 90 , 27 , 25, -86, -31, -29, -5 , 93, -60, -56 , 90, -93 , 93, -57 , 45, -90 , 60, -15 , 16 , 66 , 54 , 45, -48, -8 , 87, -42, -3 , 0 , 12, -45, -85, -71, -38 , 4 , 44, -7, -48 , 25 , 16 , 18 , 31, -8, -62 , 18, -51, -66, -61, -54 , 69, -28 , 94 , 83, -65, -46 , 99 , 49, -6 , 89 , 36 , 31 , 62, -65, -40, -87 , 41, -67 , 29 , 33, -90 , 57 , 73 , 18, -25, -94, -84, -84 , 28, -48 , 17, -54, -49, -63, -77 , 25 , 66 , 89, -84, -37, -13, -79 , 24, -97 , 58, -34 , 2 , 0, -68};
        BST tree = new BST(values);

        Arrays.sort(values);
        for (int i = 0; i < values.length; i++) System.out.print(values[i] + " ");
        System.out.println("\n");
        tree.printInOrder();

        Assert.assertTrue(isBST(tree));
        Assert.assertTrue(tree.contains(-40));

    }

    @Test
    public void removeLeaf() {
        BST tree = new BST(1, 2, 3, 4, 5);
        tree.remove(5);

        tree.printInOrder();

        Assert.assertTrue(isBST(tree));
        Assert.assertFalse(tree.contains(5));
    }

    @Test
    public void removeNodeOneChild() {
        BST tree = new BST(1, 2, 3, 4, 5);
        tree.remove(3);

        tree.printInOrder();

        Assert.assertTrue(isBST(tree));
        Assert.assertFalse(tree.contains(3));
    }

    @Test
    public void removeNodeTwoChildren() {
        BST tree = new BST(10, 20, 15, 25, 30);
        tree.remove(20);

        tree.printInOrder();

        Assert.assertTrue(isBST(tree));
        Assert.assertFalse(tree.contains(20));
    }

    @Test
    public void removeElements() {
        int[] values = new int[]{58, -40 , 17 , 90 , 27 , 25, -86, -31, -29, -5 , 93, -60, -56 , 90, -93 , 93, -57 , 45, -90 , 60, -15 , 16 , 66 , 54 , 45, -48, -8 , 87, -42, -3 , 0 , 12, -45, -85, -71, -38 , 4 , 44, -7, -48 , 25 , 16 , 18 , 31, -8, -62 , 18, -51, -66, -61, -54 , 69, -28 , 94 , 83, -65, -46 , 99 , 49, -6 , 89 , 36 , 31 , 62, -65, -40, -87 , 41, -67 , 29 , 33, -90 , 57 , 73 , 18, -25, -94, -84, -84 , 28, -48 , 17, -54, -49, -63, -77 , 25 , 66 , 89, -84, -37, -13, -79 , 24, -97 , 58, -34 , 2 , 0, -68};
        BST tree = new BST(values);

        Arrays.sort(values);
        for (int i = 0; i < values.length; i++) System.out.print(values[i] + " ");
        System.out.println("\n");
        tree.printInOrder();

        Assert.assertTrue(isBST(tree));

        tree.remove(25);
        Assert.assertTrue(isBST(tree));

        tree.remove(90);
        Assert.assertTrue(isBST(tree));

        tree.remove(-15);
        Assert.assertTrue(isBST(tree));
        Assert.assertFalse(tree.contains(-15));

        tree.remove(45);
        Assert.assertTrue(isBST(tree));

        tree.remove(-8);
        Assert.assertTrue(isBST(tree));
    }

    @Test
    public void removeRightNodeNoChildren() {
        BST tree = new BST(5, 3, 10);
        tree.remove(10);

        Assert.assertTrue(isBST(tree));
        tree.printInOrder();
        Assert.assertFalse(tree.contains(10));
    }

    @Test
    public void removeLeftNodeNoChildren() {
        BST tree = new BST(5, 3, 10);
        tree.remove(3);

        Assert.assertTrue(isBST(tree));
        tree.printInOrder();
        Assert.assertFalse(tree.contains(3));
    }

    @Test
    public void removeNodeWithLeftChild() {
        BST tree = new BST(5, 3, 10, 8, 7, 9);
        tree.remove(10);

        Assert.assertTrue(isBST(tree));
        tree.printInOrder();
        Assert.assertFalse(tree.contains(10));
    }

    @Test
    public void removeNodeWithRightChild() {
        BST tree = new BST(5, 3, 10, 8, 7, 9, 4);
        tree.remove(3);

        Assert.assertTrue(isBST(tree));
        tree.printInOrder();
        Assert.assertFalse(tree.contains(3));
    }

    @Test
    public void removeNodeWithBothChildrenNoSubtrees() {
        BST tree = new BST(5, 1, 10, 0, 2, 9, 11);
        tree.remove(1);

        Assert.assertTrue(isBST(tree));
        tree.printInOrder();
        Assert.assertFalse(tree.contains(1));
    }
    @Test

    public void removeNodeWithBothChildrenSubtrees() {
        BST tree = new BST(5, 1, 10, 0, 2, 7, 15, 6, 8, 9, 14, 20);
        tree.remove(10);

        tree.printInOrder();
        Assert.assertTrue(isBST(tree));
        Assert.assertFalse(tree.contains(10));
    }

    @Test
    public void leftRotateChainOfThree() {
        BST tree = new BST(10, 20, 30, 40);
        tree.leftRotateOn(20);

        tree.printInOrder();
        Assert.assertTrue(isBST(tree));
    }




    boolean isBST(BST tree)  {
        return isBSTUtil(tree.root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    boolean isBSTUtil(Node node, int min, int max)
    {
        /* an empty tree is BST */
        if (node == null)
            return true;

        /* false if this node violates the min/max constraints */
        if (node.value < min || node.value > max)
            return false;

        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.value) &&
                isBSTUtil(node.right, node.value+1, max));
    }

}




