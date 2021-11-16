public class BinaryTreeNode<E> {
    private E element;
    private BinaryTreeNode leftChild, rightChild;

    public BinaryTreeNode() {
        element = null;
        leftChild = null;
        rightChild = null;
    }

    public void setElement(E element){
        this.element = element;
    }

    public E getElement(){
        return element;
    }

    public void addLeftChild(BinaryTreeNode<E> node){
        leftChild = node;
    }

    public void addRightChild(BinaryTreeNode<E> node){
        rightChild = node;
    }

    public BinaryTreeNode<E> getLeftChild(){
        return leftChild;
    }

    public BinaryTreeNode<E> getRightChild(){
        return rightChild;
    }
}
