import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchTree<E extends Comparable> extends BinaryTree<E> {
    private BinarySearchTreeNode<E> root;

    public BinarySearchTree() {
        super();
        root = null;
    }

    public void insert(E e){
        if(root == null) {
            root = new BinarySearchTreeNode<E>();
            root.setElement(e);
            setRoot(root);
        }
        else {
            insert(root, e);
        }
    }

    private void insert(BinaryTreeNode<E> node, E e) {
        BinaryTreeNode<E> newNode = new BinarySearchTreeNode<E>();
        newNode.setElement(e);
      if(node.getElement().compareTo(e) > 0){
            if(node.getLeftChild() == null) {
                node.addLeftChild(newNode);
                return;
            }
            insert(node.getLeftChild(), e);
        }
        else if(node.getElement().compareTo(e) < 0){
            if(node.getRightChild() == null) {
                node.addRightChild(newNode);
                return;
            }
            insert(node.getRightChild(), e);
        }
        else return;
    }

    public void removeElement(E e) {
        removeElement(e, root);
    }

    private void removeElement(E e, BinarySearchTreeNode<E> node) {
        BinarySearchTreeNode<E> toRemove = findElement(e, node);
        if(toRemove != null) {
            E replacementElement = findReplacementNode(toRemove);
            toRemove.setElement(replacementElement);
            removeElement(e, toRemove);
        }
    }

    private E findReplacementNode(BinarySearchTreeNode<E> node) {
        if(node.getRightChild() == null) {
            return (E) node.getLeftChild().getElement();
        }
        else {
            node = (BinarySearchTreeNode<E>) node.getRightChild();
            return findMin(node);
        }
    }

    private BinarySearchTreeNode<E> findElement(E e, BinarySearchTreeNode<E> node) {
        if(node == null) {
            return null;
        }
        else if(node.getElement() == e) {
            return node;
        }
        else
        {
            if(node.getElement().compareTo(e) > 0) {
                if(node.getLeftChild() == null) {
                    return null;
                }
                return findElement(e, (BinarySearchTreeNode<E>) node.getLeftChild());
            }
            else {
                if(node.getRightChild() == null) {
                    return null;
                }
                return findElement(e, (BinarySearchTreeNode<E>) node.getRightChild());
            }
        }
    }

    public E findMin(){
        return findMin(root);
    }

    private E findMin(BinarySearchTreeNode<E> node) {
        if(node == null) {
            return null;
        }
        else if(node.getLeftChild() == null) {
            return (E) node.getElement();
        }
        else return findMin((BinarySearchTreeNode<E>) node.getLeftChild());
    }

    public E findMax(){
        return findMax(root);
    }

    private E findMax(BinarySearchTreeNode<E> node) {
        if(node == null) {
            return null;
        }
        if(node.getRightChild() == null) {
            return (E) node.getElement();
        }
        else return findMax((BinarySearchTreeNode<E>) node.getRightChild());
    }

    public boolean contains(E e){
        if(findElement(e, root) == null) {
            return false;
        }
        return true;
    }

    public void rebalance(){
        if(!(isBalanced(root))) {
            ArrayList<E> array = inOrder();
            Object[] arrays = array.toArray();

            root = null;
            rebalance(arrays);
        }
    }

    private void rebalance(Object[] array) {
        int index = array.length;

        if(index == 0) {
            return;
        }

        if (index % 2 != 0) {
            index -= 1;
        }
        index /= 2;

        insert((E) array[index]);

        Object[] firstHalf = Arrays.copyOfRange(array, 0, index);
        Object[] secondHalf = Arrays.copyOfRange(array, index+1, array.length);

        rebalance(firstHalf);
        rebalance(secondHalf);
    }

    public boolean isBalanced(BinaryTreeNode<E> node) {
        int height = height(node);
        ArrayList<E> nodesAtDistance;
        for(int i = 0; i < height; i++) {
            nodesAtDistance = getNodesAtDistance(i);
            int noOfElement = nodesAtDistance.size();
            if(noOfElement != Math.pow(2, i)) {
                return false;
            }
        }
        return true;
    }

   /* public BinarySearchTree() {
        root = null;
    }

    public void insert(Object e){
        if(root == null) {
            root = new BinaryTreeNode();
            root.setElement((Comparable) e);
            setRoot(root);
        }
        else {
            insert(root, e);
        }
    }

   private void insert(BinaryTreeNode node, Object e) {
        BinaryTreeNode newNode = new BinaryTreeNode();
        newNode.setElement((Comparable) e);
        if(node.getElement().compareTo(e) == 1){
            if(node.getLeftChild() == null) {
                node.addLeftChild(newNode);
                return;
            }
            insert(node.getLeftChild(), e);
        }
        else {
            if(node.getRightChild() == null) {
                node.addRightChild(newNode);
                return;
            }
            insert(node.getRightChild(), e);
        }
    }

    public void removeElement(Object e){
        removeElement(e, root);
    }

    private void removeElement(Object e, BinaryTreeNode node) {
        BinaryTreeNode toRemove = findElement(e, node);
        if(toRemove != null) {
            Object replacementElement = findReplacementNode(toRemove);
            toRemove.setElement((Comparable) replacementElement);
            removeElement(e, toRemove);
        }
        else {
            return;
        }
    }

    private Object findReplacementNode(BinaryTreeNode node) {
        if(node.getRightChild() == null) {
            return node.getLeftChild().getElement();
        }
        else {
            node = node.getRightChild();
            return findMin(node);
        }
    }

    private BinaryTreeNode findElement(Object e, BinaryTreeNode node) {
        if(node.getElement() == e) {
            return node;
        }
        else
        {
            if(node.getElement().compareTo(e) == 1) {
                if(node.getLeftChild() == null) {
                    return null;
                }
                return findElement(e, node.getLeftChild());
            }
            else {
                if(node.getRightChild() == null) {
                    return null;
                }
                return findElement(e, node.getRightChild());
            }
        }
    }

    public Object findMin(){
        return findMin(root);
    }

    private Object findMin(BinaryTreeNode node) {
        if(node == null) {
            return null;
        }
        else if(node.getLeftChild() == null) {
            return node.getElement();
        }
        else return findMin(node.getLeftChild());
    }

    public Object findMax(){
        return findMax(root);
    }

    private Object findMax(BinaryTreeNode node) {
        if(node == null) {
            return null;
        }
        if(node.getRightChild() == null) {
            return node.getElement();
        }
        else return findMax(node.getRightChild());
    }

    public boolean contains(Object e){
        if(findElement(e, root) == null) {
            return false;
        }
        return true;
    }

    public void rebalance(){
        if(!(isBalanced(root))) {
            ArrayList<Object> array = inOrder();
            Object[] arrays = array.toArray();

            root = null;
            rebalance(arrays);
        }
    }

    private void rebalance(Object[] array) {
        int index = array.length;

        if(index == 0) {
            return;
        }

        if (index % 2 != 0) {
                index -= 1;
            }
            index /= 2;

            insert(array[index]);

            Object[] firstHalf = Arrays.copyOfRange(array, 0, index);
            Object[] secondHalf = Arrays.copyOfRange(array, index+1, array.length);

            rebalance(firstHalf);
            rebalance(secondHalf);
    }

    public boolean isBalanced(BinaryTreeNode node) {
        int height = height(node);
        ArrayList<Object> nodesAtDistance;
        for(int i = 0; i < height; i++) {
            nodesAtDistance = getNodesAtDistance(i);
            int noOfElement = nodesAtDistance.size();
            if(noOfElement != Math.pow(2, i)) {
                return false;
            }
        }
        return true;
    }
    */
}
