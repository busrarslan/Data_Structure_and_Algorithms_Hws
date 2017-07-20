import java.util.ArrayList;
import java.util.LinkedList;

public class SingleLinkedList<E> {
    private Node<E> head;
    private int size;
    private Node<E> deleteToStringHead;
    private int deleteToStringSize=0;



    //inner class/////////////////////////////////////
    public class Node<E> {
        private E data;
        private Node<E> next;

        /**
         *
         * @param dataItem
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        /**
         *
         * @param dataItem
         * @param nodeRef
         */
        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }

    }
    ////////////////////////////////////////////////////

    /**
     *
     */
    public SingleLinkedList() {
        head = null;
        size = 0;
    }

    /**
     *
     * @return
     */
    public int deleteToStringSize() {
        return deleteToStringSize;
    }


    public Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index-1 && node != null; i++) {
            node = node.next;
        }
        return node;
    }


    /**
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    /**
     *
     * @param index
     * @param newValue
     * @return
     */
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }

    /**
     *
     * @param item
     * @return
     */
    public boolean add(E item) {
        add(size, item);
        return true;
    }

    /**
     *
     * @param index
     * @param item
     */
    public void add(int index, E item) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0)
            addFirst(item);
        else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    /**
     *
     * @param item
     */
    public void addFirst(E item) {
        if(deleteToStringSize() == 0) {
            head = new Node<E>(item, head);
            size++;
        }
        else{
            Node<E> temp;
            head=new Node<E>(deleteToStringHead.data,head);
            deleteToStringHead=deleteToStringHead.next;
            deleteToStringSize--;
            /*temp.next=head;
            temp.data=item;
            head=temp;*/
        }
    }

    /**
     *
     * @param node
     * @param item
     */
    private void addAfter(Node<E> node, E item) {
        if(deleteToStringSize() == 0) {
            node.next = new Node<E>(item, node.next);
            size++;
        }
        else {

            node.next = new Node<E>(deleteToStringHead.data, node.next);
            size++;
            deleteToStringHead=deleteToStringHead.next;
            deleteToStringSize--;
        }
    }

    /**
     *
     * @return
     */
    public Node<E> getFirst() {
        return head;
    }

    /**
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        return removeAfter(getNode(index));
    }

    /**
     *
     * @param node
     * @return
     */
    public E removeAfter(Node<E> node) {

        Node<E> temp = node.next;
        if(temp!= null)
        {
            node.next=temp.next;
            deleteToStringFunc(node);
            size--;
            return temp.data;
        }else{
            return null;
        }
    }


    public Node<E> deleteToStringFunc(Node<E> ele) {
        ++deleteToStringSize;
        Node<E> temp= deleteToStringHead;
        if(temp != null){

            deleteToStringHead = ele;
            ele.next=temp;
        }else{
            deleteToStringHead = ele;
            ele.next=null;
        }
        return deleteToStringHead;
    }

    /**
     *
     * @return
     */
    public String deletedToString(){
        Node<E> nodeRef=deleteToStringHead;
        StringBuilder result=new StringBuilder();
        if(nodeRef!=null){

            result.append(nodeRef.data);
            if(nodeRef.next!=null){

                result.append("");
            }
            nodeRef=nodeRef.next;
        }

        return result.toString();
    }

}


