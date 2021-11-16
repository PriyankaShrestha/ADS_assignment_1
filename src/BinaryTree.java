import java.util.ArrayList;

public class BinaryTree<E> {
    private BinaryTreeNode<E> root;
    private int size;

    public BinaryTree() {
        root = null;
    }

    public BinaryTreeNode<E> getRoot(){
        return root;
    }

    public void setRoot(BinaryTreeNode<E> root){
        this.root = root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size(){
        ArrayList<E> array = inOrder();
        return array.size();
    }

    public boolean contains(E e){
        ArrayList<E> array = inOrder();
        for(int i = 0; i < array.size(); i++) {
            if(array.get(i) == e) {
                return true;
            }
        }
        return false;
    }


    public ArrayList<E> inOrder(){
        if(!isEmpty()) {
            ArrayList<E> array = new ArrayList<>();
            return inOrder(root, array);
        }
        return null;
    }

    private ArrayList<E> inOrder(BinaryTreeNode<E> node, ArrayList<E> array) {
        // Inorder: traverse left subtree, visit root, traverse right subtree
        if(node == null) {
            return null;
        }
        else {
            inOrder(node.getLeftChild(), array);
            array.add(node.getElement());
            inOrder(node.getRightChild(), array);
        }
        return array;
    }


    public ArrayList<E> preOrder(){
        if(!isEmpty()) {
            ArrayList<E> array = new ArrayList<>();
            return preOrder(root, array);
        }
        return null;
    }

    private ArrayList<E> preOrder(BinaryTreeNode<E> node, ArrayList<E> array) {
        //	Preorder: visit root, traverse subtree from left to right
        if(node == null) {
            return null;
        }
        else {
            array.add(node.getElement());
            preOrder(node.getLeftChild(), array);
            preOrder(node.getRightChild(), array);
        }
        return array;
    }


    public ArrayList<E> postOrder(){
        if(!isEmpty()) {
            ArrayList<E> array = new ArrayList<>();
            return postOrder(root, array);
        }
        return null;
    }

    private ArrayList<E> postOrder(BinaryTreeNode<E> node, ArrayList<E> array) {
        // Postorder: traverse subtree from left to right, visit root

        if(node == null) {
            return null;
        }
        else {
            postOrder(node.getLeftChild(), array);
            postOrder(node.getRightChild(), array);
            array.add(node.getElement());
        }
        return array;
    }

    public ArrayList<E> getNodesAtDistance(int distance) {
        ArrayList<E> array = new ArrayList<>();
        getNodesAtDistance(root, distance, array);
        return array;
    }

    private void getNodesAtDistance(BinaryTreeNode<E> node, int distance, ArrayList<E> array) {
        if(node == null) {
            return;
        }

        if (distance == 0) {
            array.add(node.getElement());
        }

        getNodesAtDistance(node.getLeftChild(), distance - 1, array);
        getNodesAtDistance(node.getRightChild(), distance - 1, array);
    }

    public ArrayList<E> levelOrder(){
        // Levelorder: visit each node from each level
        if(!isEmpty()) {
            ArrayList<E> array = new ArrayList<>();
            for (int i = 0; i <= height(); i++) {
                array.addAll(getNodesAtDistance(i));
            }
            return array;
        }
        return null;
    }

    public int height(){
        return height(root);
    }

    public int height(BinaryTreeNode<E> root) {
        if(root == null) {
            return -1;
        }
        if(root.getLeftChild() == null && root.getRightChild() == null) {
            return 0;
        }
        return 1 + Math.max(height(root.getLeftChild()), height(root.getRightChild()));
    }

    /*private BinaryTreeNode root;
    private int size;

    public BinaryTree() {
        //array = new ArrayList<>();
        root = null;
    }

    public BinaryTreeNode getRoot(){
        return root;
    }

    public void setRoot(BinaryTreeNode root){
        this.root = root;
    }

    public boolean isEmpty(){
        if(root == null) {
            return true;
        }
        else return false;
    }

    public int size(){
        ArrayList<Object> array = inOrder();
        return array.size();
    }

    public boolean contains(Object e){
        ArrayList<Object> array = inOrder();
        for(int i = 0; i < array.size(); i++) {
            if(array.get(i) == e) {
                return true;
            }
        }
        return false;
    }


    public ArrayList<Object> inOrder(){
       ArrayList<Object> array = new ArrayList<>();
       return inOrder(root, array);
    }

    private ArrayList<Object> inOrder(BinaryTreeNode node, ArrayList<Object> array) {
        // Inorder: traverse left subtree, visit root, traverse right subtree
        if(node == null) {
            return null;
        }
        else {
            inOrder(node.getLeftChild(), array);
            array.add(node.getElement());
            inOrder(node.getRightChild(), array);
        }
        return array;
    }


    public ArrayList<Object> preOrder(){
        ArrayList<Object> array = new ArrayList<>();
        return preOrder(root, array);
    }

    private ArrayList<Object> preOrder(BinaryTreeNode node, ArrayList<Object> array) {
        //	Preorder: visit root, traverse subtree from left to right
        if(node == null) {
            return null;
        }
        else {
            array.add(node.getElement());
            preOrder(node.getLeftChild(), array);
            preOrder(node.getRightChild(), array);
        }
        return array;
    }


    public ArrayList<Object> postOrder(){
       ArrayList<Object> array = new ArrayList<>();
       return postOrder(root, array);
    }

    private ArrayList<Object> postOrder(BinaryTreeNode node, ArrayList<Object> array) {
        // Postorder: traverse subtree from left to right, visit root

        if(node == null) {
            return null;
        }
        else {
            postOrder(node.getLeftChild(), array);
            postOrder(node.getRightChild(), array);
            array.add(node.getElement());
        }
        return array;
    }

    public ArrayList<Object> getNodesAtDistance(int distance) {
        ArrayList<Object> array = new ArrayList<>();
        getNodesAtDistance(root, distance, array);
        return array;
    }

    private void getNodesAtDistance(BinaryTreeNode node, int distance, ArrayList<Object> array) {
        if(node == null) {
            return;
        }

        if (distance == 0) {
            array.add(node.getElement());
        }

        getNodesAtDistance(node.getLeftChild(), distance - 1, array);
        getNodesAtDistance(node.getRightChild(), distance - 1, array);
    }

    public ArrayList<Object> levelOrder(){
        // Levelorder: visit each node from each level
        ArrayList<Object> array = new ArrayList<>();
        for(int i = 0; i <= height(); i++) {
            for(var obj: getNodesAtDistance(i)) {
                array.add(obj);
            }
        }
        return array;
    }

    public int height(){
        return height(root);
    }

    public int height(BinaryTreeNode root) {
        if(root == null) {
            return -1;
        }
        if(root.getLeftChild() == null && root.getRightChild() == null) {
            return 0;
        }
        return 1 + Math.max(height(root.getLeftChild()), height(root.getRightChild()));
    }

     */
}
