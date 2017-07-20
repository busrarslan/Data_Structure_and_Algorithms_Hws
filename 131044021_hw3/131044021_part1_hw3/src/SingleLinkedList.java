import java.util.Iterator;


//Single linkedList implement methods
public class SingleLinkedList<E>
{
    private Node<E> head;
    private int size;

    /**
     *
     * @return
     */
    public Iterator<E> iterator() {
        return new ListIterator<E>(head);
    }

    /**
     *
     * @param <T>
     */
    private class ListIterator<T> implements Iterator<T> {

        private Node<T> current;

        /**
         *
         * @param first
         */
        public  ListIterator(Node<T> first) {
            current = first;
        }

        /**
         *
         * @return
         */
        public boolean hasNext() {

            return current != null;
        }

        /**
         *
         * @return
         */
        public T next() {
            if(hasNext()) {
                T item = current.data;
                current = current.next;
                return item;
            }
            return null;
        }


    }


    //inner class/////////////////////////////////////
    private static class Node<E> {
        private E data;
        private Node<E> next;

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
    public SingleLinkedList() {
        head = null;
        size=0;
    }

    /**
     *
     * @param index
     * @return
     */
    private Node<E> getNode(int index){
        Node<E> node= head;
        for(int i=0; i<index && node !=null; i++){
            node= node.next;
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
    public E get(int index){
        if(index<0 || index>=size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node= getNode(index);
        return node.data;
    }

    /**
     *
     * @param index
     * @param newValue
     * @return
     */
    public E set(int index, E newValue){
        if(index<0 || index>=size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node= getNode(index);
        E result= node.data;
        node.data=newValue;
        return result;
    }

    /**
     *
     * @param index
     * @param item
     */
    public void add(int index, E item){
        if(index<0 || index>size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if(index==0)
            addFirst(item);
        else{
            Node<E> node= getNode(index-1);
            addAfter(node,item);
        }
    }

    /**
     *
     * @param item
     * @return
     */
    public boolean add(E item){
        add(size, item);
        return true;
    }

    /**
     *
     * @param item
     */
    public void addFirst(E item){
        head= new Node<E>(item,head);
        size++;
    }

    /**
     *
     * @param node
     * @param item
     */
    private void addAfter(Node<E> node, E item){
        node.next=new Node<E>(item,node.next);
        size++;
    }


    /**
     *
     * @return
     */
    @Override
    public String toString(){
        Node<Character> nodeRef= (Node<Character>) head;
        String result="";
        while(nodeRef !=null){
            char s=nodeRef.data;
            result+=nodeRef.data;
            result+="\n";
            nodeRef= nodeRef.next;
        }
        return result;
    }

}
