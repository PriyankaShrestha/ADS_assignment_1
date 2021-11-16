import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    BinaryTree<Integer> tree;

    @BeforeEach
    public void createTree() {
        tree = new BinaryTree<Integer>();
    }

    @Test
    public void getRootWhenTreeIsEmpty() {
        assertNull(tree.getRoot());
    }

    @Test
    public void getRootWhenTreeIsNotEmpty() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>();
        node.setElement(5);
        tree.setRoot(node);
        assertEquals(node.getElement(), 5);
    }

    @Test
    public void isEmptyWhenNotEmpty() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>();
        node.setElement(5);
        tree.setRoot(node);
        assertFalse(tree.isEmpty());
    }

    @Test
    public void isEmptyWhenIsEmpty() {
        assertTrue(tree.isEmpty());
    }

    @Test
    public void contains() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>();
        node.setElement(5);
        tree.setRoot(node);
        assertFalse(tree.contains(2));
        assertTrue(tree.contains(5));
    }

    @Test
    public void heightWhenTreeIsEmpty() {
        assertEquals(-1, tree.height());
    }

    @Test
    public void heightWhenTreeIsNotEmpty() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>();
        node.setElement(5);

        BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>();
        leftChild.setElement(5);
        node.addLeftChild(leftChild);

        BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>();
        rightChild.setElement(15);
        node.addRightChild(rightChild);

        BinaryTreeNode<Integer> leftChildOfFive = new BinaryTreeNode<Integer>();
        leftChildOfFive.setElement(3);
        leftChild.addLeftChild(leftChildOfFive);

        tree.setRoot(node);

        assertEquals(2, tree.height());
        assertEquals(1, tree.height(leftChild));
    }

    @Test
    public void inOrder() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
        root.setElement(6);

        BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>();
        leftChild.setElement(5);
        root.addLeftChild(leftChild);

        BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>();
        rightChild.setElement(15);
        root.addRightChild(rightChild);

        BinaryTreeNode<Integer> leftChildOfFive = new BinaryTreeNode<Integer>();
        leftChildOfFive.setElement(3);
        leftChild.addLeftChild(leftChildOfFive);

        tree.setRoot(root);

        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(3, 5, 6, 15));
        assertEquals(array, tree.inOrder());
    }

    @Test
    public void preOrder() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
        root.setElement(6);

        BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>();
        leftChild.setElement(5);
        root.addLeftChild(leftChild);

        BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>();
        rightChild.setElement(15);
        root.addRightChild(rightChild);

        BinaryTreeNode<Integer> leftChildOfFive = new BinaryTreeNode<Integer>();
        leftChildOfFive.setElement(3);
        leftChild.addLeftChild(leftChildOfFive);

        tree.setRoot(root);

        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(6, 5, 3, 15));
        assertEquals(array, tree.preOrder());
    }

    @Test
    public void postOrder() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
        root.setElement(6);

        BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>();
        leftChild.setElement(5);
        root.addLeftChild(leftChild);

        BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>();
        rightChild.setElement(15);
        root.addRightChild(rightChild);

        BinaryTreeNode<Integer> leftChildOfFive = new BinaryTreeNode<Integer>();
        leftChildOfFive.setElement(3);
        leftChild.addLeftChild(leftChildOfFive);

        tree.setRoot(root);

        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(3, 5, 15, 6));
        assertEquals(array, tree.postOrder());
    }

    @Test
    public void levelOrder() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
        root.setElement(6);

        BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>();
        leftChild.setElement(5);
        root.addLeftChild(leftChild);

        BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>();
        rightChild.setElement(15);
        root.addRightChild(rightChild);

        BinaryTreeNode<Integer> leftChildOfFive = new BinaryTreeNode<Integer>();
        leftChildOfFive.setElement(3);
        leftChild.addLeftChild(leftChildOfFive);

        tree.setRoot(root);

        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(6, 5, 15, 3));
        assertEquals(array, tree.levelOrder());
    }

    @Test
    public void inOrderWhenEmpty() {
        assertNull(tree.inOrder());
    }

    @Test
    public void preOrderWhenEmpty() {
        assertNull(tree.preOrder());
    }

    @Test
    public void postOrderWhenEmpty() {
        assertNull(tree.postOrder());
    }

    @Test
    public void levelOrderWhenEmpty() {
        assertNull(tree.levelOrder());
    }
}