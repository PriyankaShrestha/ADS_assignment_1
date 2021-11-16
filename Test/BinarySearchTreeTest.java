import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree<Integer> tree;

    @BeforeEach
    public void createTree() {
        tree = new BinarySearchTree<Integer>();
    }

    @Test
    public void insertElement() {
        tree.insert(2);
        tree.insert(5);
        tree.insert(7);
        tree.insert(10);
        tree.insert(8);

        assertTrue(tree.contains(2));
        assertTrue(tree.contains(10));
        assertFalse(tree.contains(12));
    }

    @Test
    public void insertDuplicateElement() {
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(3);
        assertEquals(3, tree.size());
    }

    @Test
    public void findMinWhenTreeIsNull() {
        assertNull(tree.findMin());
    }

    @Test
    public void findMin() {
        tree.insert(2);
        tree.insert(5);
        tree.insert(7);
        tree.insert(10);
        tree.insert(8);

        assertEquals(2, tree.findMin());
    }

    @Test
    public void findMaxWhenTreeIsNull() {
        assertNull(tree.findMax());
    }

    @Test
    public void findMax() {
        tree.insert(2);
        tree.insert(5);
        tree.insert(7);
        tree.insert(10);
        tree.insert(8);

        assertEquals(10, tree.findMax());
    }

    @Test
    public void removeElement() {
        tree.insert(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(15);
        tree.insert(11);

        tree.removeElement(10);
        assertEquals(11, tree.getRoot().getElement());
        assertFalse(tree.contains(10));
    }

    @Test
    public void removeElementWhenElementIsNotPresent() {
        tree.removeElement(2);
        assertFalse(tree.contains(2));
    }

    @Test
    public void rebalance() {
        tree.insert(4);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(15);
        tree.insert(11);

        tree.rebalance();

        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(7, 4, 12, 3, 5, 11, 15));
        assertEquals(array, tree.levelOrder());
    }

    @Test
    public void rebalanceAnother() {
        tree.insert(4);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(15);
        tree.insert(11);
        tree.insert(17);
        tree.insert(19);
        tree.insert(20);
        tree.insert(21);
        tree.insert(1);
        tree.insert(6);

        tree.rebalance();

        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(11, 5, 19, 3, 7, 15, 21, 1, 4, 6, 12, 17, 20));
        assertEquals(array, tree.levelOrder());
    }
}