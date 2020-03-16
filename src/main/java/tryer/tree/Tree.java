package tryer.tree;

public interface Tree {
    void insert(int value);

    void remove(int value);

    boolean contains(int value);

    void printInOrder();

    void leftRotateOn(int value); //first found value

    void rightRotateOn(int value); //first found value

    int[] traverseInOrder();

    int getSize();
}
