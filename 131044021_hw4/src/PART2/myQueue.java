package PART2;//Queue methods
//E element();
//boolean offer(E e);
//E peek();
//E poll();
//E remove();

import java.util.Queue;
import java.util.Stack;

public class myQueue<E> extends KWLinkedList<E> {

    /**
     *
     */
    public myQueue() {
        super();
    }


    ////////////////////////part1 reverse method///////////////////////
    /**
     *
     * @param myQ
     * @return
     */
    public myQueue<E> reverse(myQueue<E> myQ){
        int tempSize= myQ.getSize();
        int i=1;
        for(int k=0; k<tempSize; k++) {
            myQ.add(tempSize - i, myQ.removeFirst());
            i++;
        }
        return myQ;
    }


    ////////////////////////////////part2 reverseQueue method/////////////////////
    /**
     *
     * @param q
     * @return
     */
    public Queue<E> reverseQueue(Queue<E> q) {


        Stack<E> temp=new Stack<E>();
        reverseQueue(q,temp);

        for(int i=temp.size(); i>0 ; i--)
        {
            q.add(temp.pop());
        }


        return q;

    }

    /**
     *
     * @param q
     * @param temp
     */
    private void reverseQueue(Queue<E> q, Stack<E> temp) {
        if(q.size()<= 0)
            return;
        else
        {
            temp.add(q.poll());
            reverseQueue(q, temp);
        }
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean offer(E e) {
        addLast(e);
        return true;
    }

    /**
     *
     * @return
     */
    public E peek() {
        if(getSize()== 0)
            return null;
        else
            return getFirst();
    }

    /**
     *
     */
    public void poll(){
        removeFirst();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString().replace('[', ' ').replace(']',' ');
    }
}

