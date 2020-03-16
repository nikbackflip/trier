package tryer.tree.bst2;

import org.junit.Assert;
import org.junit.Test;


import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

//wtf VERDICT BST2 kinda works
public class Bst2Test {

    @Test
    public void emptyTreeSizeIsZero() {
        BST2 tree = new BST2();

        assertEquals(0, tree.getSize());
    }

    @Test
    public void rootOnlyTreeSizeIsOne() {
        BST2 tree = new BST2(100);

        assertEquals(1, tree.getSize());
    }

    @Test
    public void multipleInsertsSizeCalculated() {
        int[] values = new int[]{58, -40 , 17 , 90 , 27 , 25, -86, -31, -29, -5 , 93, -60, -56 , 90, -93 , 93, -57 , 45, -90 , 60, -15 , 16 , 66 , 54 , 45, -48, -8 , 87, -42, -3 , 0 , 12, -45, -85, -71, -38 , 4 , 44, -7, -48 , 25 , 16 , 18 , 31, -8, -62 , 18, -51, -66, -61, -54 , 69, -28 , 94 , 83, -65, -46 , 99 , 49, -6 , 89 , 36 , 31 , 62, -65, -40, -87 , 41, -67 , 29 , 33, -90 , 57 , 73 , 18, -25, -94, -84, -84 , 28, -48 , 17, -54, -49, -63, -77 , 25 , 66 , 89, -84, -37, -13, -79 , 24, -97 , 58, -34 , 2 , 0, -68};

        BST2 tree = new BST2(values);

        assertEquals(Arrays.stream(values).distinct().count(), tree.getSize());
    }

    @Test
    public void rootRemovedSizeDecreased() {
        BST2 tree = new BST2(1);

        tree.remove(1);

        assertEquals(0, tree.getSize());
    }

    @Test
    public void leafRemovedSizeDecreased() {
        BST2 tree = new BST2(1, 2, 3, 4, 5);

        tree.remove(5);

        assertEquals(4, tree.getSize());
    }

    @Test
    public void traverseInOrder() {
        int[] values = new int[]{58, -40 , 17 , 90 , 27 , 25, -86, -31, -29, -5 , 93, -60, -56 , 90, -93 , 93, -57 , 45, -90 , 60, -15 , 16 , 66 , 54 , 45, -48, -8 , 87, -42, -3 , 0 , 12, -45, -85, -71, -38 , 4 , 44, -7, -48 , 25 , 16 , 18 , 31, -8, -62 , 18, -51, -66, -61, -54 , 69, -28 , 94 , 83, -65, -46 , 99 , 49, -6 , 89 , 36 , 31 , 62, -65, -40, -87 , 41, -67 , 29 , 33, -90 , 57 , 73 , 18, -25, -94, -84, -84 , 28, -48 , 17, -54, -49, -63, -77 , 25 , 66 , 89, -84, -37, -13, -79 , 24, -97 , 58, -34 , 2 , 0, -68};
        BST2 tree = new BST2(values);

        int[] traverseResult = tree.traverseInOrder();

        values = Arrays.stream(values).distinct().sorted().toArray();
        assertArrayEquals(values, traverseResult);
    }

    @Test
    public void buildSimple() {
        BST2 tree = new BST2(1, 2, 3, 4, 5);

        tree.printInOrder();

        assertTrue(isBST(tree));
        assertIsBST(tree.root);
    }

    @Test
    public void buildWithRandomElements() {
        int[] values = new int[]{58, -40 , 17 , 90 , 27 , 25, -86, -31, -29, -5 , 93, -60, -56 , 90, -93 , 93, -57 , 45, -90 , 60, -15 , 16 , 66 , 54 , 45, -48, -8 , 87, -42, -3 , 0 , 12, -45, -85, -71, -38 , 4 , 44, -7, -48 , 25 , 16 , 18 , 31, -8, -62 , 18, -51, -66, -61, -54 , 69, -28 , 94 , 83, -65, -46 , 99 , 49, -6 , 89 , 36 , 31 , 62, -65, -40, -87 , 41, -67 , 29 , 33, -90 , 57 , 73 , 18, -25, -94, -84, -84 , 28, -48 , 17, -54, -49, -63, -77 , 25 , 66 , 89, -84, -37, -13, -79 , 24, -97 , 58, -34 , 2 , 0, -68};
        BST2 tree = new BST2(values);

        int[] traverseResult = tree.traverseInOrder();

        assertTrue(isBST(tree));
        assertIsBST(tree.root);
        values = Arrays.stream(values).distinct().sorted().toArray();
        assertArrayEquals(values, traverseResult);
    }

    @Test
    public void removeLeaf() {
        BST2 tree = new BST2(1, 2, 3, 4, 5);

        tree.remove(5);

        assertTrue(isBST(tree));
        assertIsBST(tree.root);
        Assert.assertFalse(tree.contains(5));
    }

    @Test
    public void removeNodeOneChild() {
        BST2 tree = new BST2(1, 2, 3, 4, 5);

        tree.remove(3);

        assertTrue(isBST(tree));
        assertIsBST(tree.root);
        Assert.assertFalse(tree.contains(3));
    }

    @Test
    public void removeNodeTwoChildren() {
        BST2 tree = new BST2(10, 20, 15, 25, 30);

        tree.remove(20);

        assertTrue(isBST(tree));
        assertIsBST(tree.root);
        Assert.assertFalse(tree.contains(20));
    }

    @Test
    public void removeAllElements() {
        int[] values = new int[]{58, -40 , 17 , 90 , 27 , 25, -86, -31, -29, -5 , 93, -60, -56 , 90, -93 , 93, -57 , 45, -90 , 60, -15 , 16 , 66 , 54 , 45, -48, -8 , 87, -42, -3 , 0 , 12, -45, -85, -71, -38 , 4 , 44, -7, -48 , 25 , 16 , 18 , 31, -8, -62 , 18, -51, -66, -61, -54 , 69, -28 , 94 , 83, -65, -46 , 99 , 49, -6 , 89 , 36 , 31 , 62, -65, -40, -87 , 41, -67 , 29 , 33, -90 , 57 , 73 , 18, -25, -94, -84, -84 , 28, -48 , 17, -54, -49, -63, -77 , 25 , 66 , 89, -84, -37, -13, -79 , 24, -97 , 58, -34 , 2 , 0, -68};
        BST2 tree = new BST2(values);
        List<Integer> toRemove = Arrays.stream(values).distinct().boxed().collect(Collectors.toList());
        Collections.shuffle(toRemove/*, new Random(10)*/);

        toRemove.forEach((i) -> {
            tree.remove(i);
            assertTrue(isBST(tree));
            assertIsBST(tree.root);
        });

        assertEquals(0, tree.getSize());
    }

    @Test
    public void removeRightNodeNoChildren() {
        BST2 tree = new BST2(5, 3, 10);

        tree.remove(10);

        assertTrue(isBST(tree));
        assertIsBST(tree.root);
        Assert.assertFalse(tree.contains(10));
    }

    @Test
    public void removeLeftNodeNoChildren() {
        BST2 tree = new BST2(5, 3, 10);

        tree.remove(3);

        assertTrue(isBST(tree));
        assertIsBST(tree.root);
        Assert.assertFalse(tree.contains(3));
    }

    @Test
    public void removeNodeWithLeftChild() {
        BST2 tree = new BST2(5, 3, 10, 8, 7, 9);

        tree.remove(10);

        assertTrue(isBST(tree));
        assertIsBST(tree.root);
        Assert.assertFalse(tree.contains(10));
    }

    @Test
    public void removeNodeWithRightChild() {
        BST2 tree = new BST2(5, 3, 10, 8, 7, 9, 4);

        tree.remove(3);

        assertTrue(isBST(tree));
        assertIsBST(tree.root);
        Assert.assertFalse(tree.contains(3));
    }

    @Test
    public void removeNodeWithBothChildrenNoSubtrees() {
        BST2 tree = new BST2(5, 1, 10, 0, 2, 9, 11);

        tree.remove(1);

        assertTrue(isBST(tree));
        assertIsBST(tree.root);
        Assert.assertFalse(tree.contains(1));
    }

    @Test
    public void removeNodeWithBothChildrenSubtrees() {
        BST2 tree = new BST2(5, 1, 10, 0, 2, 7, 15, 6, 8, 9, 14, 20);

        tree.remove(10);

        tree.printInOrder();
        Assert.assertFalse(tree.contains(10));
    }

    @Test(expected = AssertionError.class)
    public void notATreeAssertionFailed() {
        Node left = new Node(5);
        Node right = new Node(10);
        Node root = new Node(0, right, left);

        assertIsBST(root);

    }

    //todo rewrite yourself
    boolean isBST(BST2 tree)  {
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


    private boolean isBst(BST2 tree) {
        try {
            assertIsBST(tree.root);
        } catch (AssertionError ex) {
            return false;
        }
        return true;
    }

    private void assertIsBST(Node node)  {
        if (node == null) return;
        if ((node.left != null && node.left.value >= node.value) || (node.right != null && node.right.value <= node.value))
            throw new AssertionError();
        assertIsBST(node.left);
        assertIsBST(node.right);
    }


}




