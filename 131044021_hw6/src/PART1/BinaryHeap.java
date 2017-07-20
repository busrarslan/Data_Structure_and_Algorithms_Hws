package PART1;


import java.util.*;

public class BinaryHeap<E> extends BinaryTree<E> implements Queue<E> {

    private int frequentFlyerMax;

    public BinaryHeap(){
        root= new Node(frequentFlyerMax);
    }

    Comparator<E> comparator=null;
    ////////////////////implement queue////////////////////////////////
    @Override
    public int size() {
        return size();
    }


    @Override
    public boolean isEmpty() {
        return size() == 0;
    }


    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean add(E item) {
        return offer(item);
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) {
        return false;
    }

    /**
     *
     * @param c
     * @return
     */
    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    /**
     *
     */
    @Override
    public void clear() {
    }

    /**
     *
     * @param c
     * @return
     */
    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    /**
     *
     * @param c
     * @return
     */
    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    /**
     *
     * @param c
     * @return
     */
    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean offer(E item) {
        insert(item);
        int child = insert(item).size() - 1;
        int parent = (child - 1) / 2;
        while (parent >= 0 && compare(insert(item).get(parent), insert(item).get(child)) > 0){
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
        return true;
    }


    /**
     *
     * @param i
     * @param j
     */
    protected void swap(int i, int j) {
        E tmp = tree.get(i);
        tree.set(i, tree.get(j));
        tree.set(j, tmp);
    }

    /**
     *
     * @return
     */
    @Override
    public E remove() {
        throw new NoSuchElementException();
    }

    /**
     *
     * @return
     */
    @Override
    public E poll() {
           return null;
    }

    /**
     *
     * @return
     */
    @Override
    public E element() {
        if (isEmpty())
            throw new NoSuchElementException();
        return peek();
    }

    /**
     *
     * @return
     */
    @Override
    public E peek() {
        if (size() == 0)
            return null;
        else
            return (E)root;
    }

    ///////////////////////////////////////////////////////////////

    /**
     *
     * @param left
     * @param right
     * @return
     */
    private int compare(E left, E right){
        if(comparator != null){
            return comparator.compare(left,right);
        }else{
            return ( (Comparable < E > ) left).compareTo(right);
        }
    }

}
