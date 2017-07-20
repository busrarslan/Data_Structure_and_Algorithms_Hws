//Single linkedList implement methods
//reverseToString
public class SingleLinkedList<E>
{
    private Node<E> head;

    private int size;

    /**
     *
     * @return
     */
    public Node<E> getHead() {
        return head;
    }


    /**
     *
     * @param nodeCurrent
     * @return
     */
    public Node  reverse(Node nodeCurrent){
        if(nodeCurrent==null){
            return null;
        }
        if(nodeCurrent.next==null){
            head = nodeCurrent;
            return null;
        }
        reverse(nodeCurrent.next);
        nodeCurrent.next.next = nodeCurrent;
        nodeCurrent.next = null;
        return head;
    }


    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("list" + head);
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
     * @return
     */
    public Node<E> getNext()
    {
        return head.next;
    }

    /**
     *
     */
    public SingleLinkedList() {
        head = null;
        size=0;
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
     * @param item
     */
    public void add(E item){
        if (head == null) {
            head= new Node<E>(item,head);
            return;
        }
        Node<E> temp =head;
        while(temp.next!=null)
            temp=temp.next;

        temp.next=new Node<E>(item);
    }

    /**
     *
     * @param node
     * @return
     */
    public String reverseToString(Node node) {
        String a="";
        while (node != null) {
            a+=node.data + " ";
            node = node.next;
        }
        return a;
    }

}