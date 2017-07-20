package PART1;

import java.util.NoSuchElementException;

public class StackC<E> implements StackInterface<E> {

    //composition ilişkisi
    private Node<E> head;
    private int size;


    //inner class/////////////////////////////////////
    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(){
            next=null;
        }
        /**
         *
         * @param dataItem
         */
        private Node(E dataItem){
            data=dataItem;
            next=null;
        }

        /**
         *
         * @param dataItem
         * @param nodeRef
         */
        private Node(E dataItem, Node<E> nodeRef){
            data= dataItem;
            next= nodeRef;
        }

    }
    ////////////////////////////////////////////////////

    /**
     *
     */
    //stack constructor
    public StackC()
    {
        head = null;
        size=0;
    }

    /**
     *
     * @param item
     */
    @Override
    public void push(E item) {
        Node<E> tempNode = new Node(item);

        if(head == null)
        {
            head = tempNode;
        } else
        {
            tempNode.next = head;
            head = tempNode;
        }
        //eleman eklendigi icin size arttirilir
        size++;
    }

    /**
     *
     * @return
     */
    @Override
    public E pop()
    {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");

        E elem = head.data;
        head = head.next;
        size--;

        return elem;
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {

        return size;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {

        return head == null;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        int tempSize=0;
        StringBuilder stringBuilder = new StringBuilder();
        Node current = head;
        stringBuilder.insert(0, ' ');
        while (current != null) {
            stringBuilder.insert(0, current.data);
            ++tempSize;
            if(size() != tempSize)
                stringBuilder.insert(0,", ");
            current = current.next;
         }

         stringBuilder.insert(0, ' ');
         return stringBuilder.toString();
    }


 }
