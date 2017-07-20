//yararlanılan kaynaklar
//http://www.algolist.net/Data_structures/Binary_search_tree/Insertion

package PART1;

import javax.swing.tree.TreeNode;
import java.util.*;

public class BinarySearchTree<E extends Comparable> extends BinaryTree<E> {

    protected boolean addReturn;
    protected E deleteReturn;

    /**
     *
     * @param item
     * @return
     */
    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }

    /** Recursive add method.
     post: The data field addReturn is set true if the item is added to
     the tree, false if the item is already in the tree.
     @param localRoot The local root of the subtree
     @param item The object to be inserted
     @return The new local root that now contains the
     inserted item
     */
    /**
     *
     * @param localRoot
     * @param item
     * @return
     */
    private Node < E > add(Node < E > localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree — insert it.
            addReturn = true;
            return new Node < E > (item);
        }
        else if (item.compareTo(localRoot.data) == 0) {
            // item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        }
        else if (item.compareTo(localRoot.data) < 0) {
            // item is less than localRoot.data
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        }
        else {
            // item is greater than localRoot.data
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

    /**
     *
     * @return
     */
    public Iterator<E> levelOrderiterator()
    {
        return new MyIterator();
    }
    //pre-order
    private class MyIterator implements Iterator<E>
    {
        Queue<Node<E>> queue = new LinkedList<>();

        /**
         *
         */
        public MyIterator()
        {
            if(root != null) queue.add(root);
        }

        /**
         *
         * @return
         */
        public boolean hasNext()
        {
            return !queue.isEmpty();
        }

        /**
         *
         * @return
         */
        public E next()
        {
            Node<E> cur = queue.poll();
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);



            return cur.data;
        }//end of next()

        /**
         *
         */
        public void remove()
        {
            throw new IllegalStateException("kullanma");
        }
    }//end of MyIterator


}



