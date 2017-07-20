//yararlanılan kaynaklar
//https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java
//http://www.java2blog.com/2014/07/binary-tree-preorder-traversal-in-java.html


package PART1;

import java.io.*;
import java.util.*;


public class BinaryTree<E> implements Iterable<E> {

    /** Class to encapsulate a tree node. */
    protected static class Node < E >
            implements Serializable {
        // Data Fields
        /** The information stored in this node. */
        public E data;

        /** Reference to the left child. */
        public Node < E > left;

        /** Reference to the right child. */
        public Node < E > right;


        // Constructors
        /** Construct a node with given data and no children.
         @param data The data to store in this node
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        // Methods
        /** Return a string representation of the node.
         @return A string representation of the data fields
         */
        public String toString() {
            return data.toString();
        }
    }


    // Data Field
    /** The root of the binary tree */
    protected Node < E > root;
    protected E value;


    public BinaryTree() {
        root = null;
    }

    protected BinaryTree(Node < E > root) {
        this.root = root;
    }

    /**
     *
     * @param node
     */
    public void insert(Node node) {
        if(root == null) {
            root = node;
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while(true) {
            Node n = queue.remove();

            if(n.left == null) {
                n.left = node;
                break;
            } else {
                queue.offer(n.left);
            }

            if(n.right == null) {
                n.right = node;
                break;
            } else {
                queue.offer(n.right);
            }
        }
    }


    /**
     *
     * @param data
     * @param leftTree
     * @param rightTree
     */
    public BinaryTree(E data, BinaryTree < E > leftTree,
                      BinaryTree < E > rightTree) {
        root = new Node < E > (data);
        if (leftTree != null) {
            root.left = leftTree.root;
        }
        else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        }
        else {
            root.right = null;
        }
    }


    /** Return the left subtree.
     @return The left subtree or null if either the root or
     the left subtree is null
     */
    public BinaryTree < E > getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree < E > (root.left);
        }
        else {
            return null;
        }
    }

    /** Return the right sub-tree
     @return the right sub-tree or
     null if either the root or the
     right subtree is null.
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        } else {
            return null;
        }
    }


    /**** BEGIN EXERCISE ****/
    /** Return the data field of the root
     @return the data field of the root
     or null if the root is null
     */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }


    // End of method add.
    /**** END EXERCISE ****/

    /** Determine whether this tree is a leaf.
     @return true if the root has no children
     */
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /** Perform a preorder traversal.
     @param node The local root
     @param depth The depth
     @param sb The string buffer to save the output
     */
    private void preOrderTraverse(Node < E > node, int depth,
                                  StringBuilder sb) {
        if(node!=null) {
            sb.append(node.toString());
            sb.append(" ");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }


    /** Method to read a binary tree.
     pre: The input consists of a preorder traversal
     of the binary tree. The line "null" indicates a null tree.
     @return The binary tree
     @throws IOException If there is an input error
      * @param bR The input file
     */
    public static BinaryTree < String >
    readBinaryTree(BufferedReader bR) throws IOException {
        // Read a line and trim leading and trailing spaces.
        String data = bR.readLine().trim();
        if (data.equals("null")) {
            return null;
        }
        else {
            BinaryTree < String > leftTree = readBinaryTree(bR);
            BinaryTree < String > rightTree = readBinaryTree(bR);
            return new BinaryTree < String > (data, leftTree, rightTree);
        }
    }

    /**
     *
     * @return
     */
    public Iterator<E> iterator () {
        return new myIterator();
    }

    protected class myIterator implements Iterator<E> {
        private final Stack<Node<E>> stack;

        /**
         *
         */
        public myIterator() {
            stack = new Stack<Node<E>>();
            stack.add(root);
        }

        /**
         *
         * @return
         */
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         *
         * @return
         */
        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException("No more nodes remain to iterate");

            final Node<E> node = stack.pop();

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);

            return node.data;
        }

        /**
         *
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Invalid operation for pre-order iterator.");
        }
    }

}
