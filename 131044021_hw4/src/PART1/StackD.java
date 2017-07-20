package PART1;

import java.util.*;

public class StackD<E> implements StackInterface<E> {

    //composition ilişkisi
    private Queue<E> queue;


    /**
     *
     */
    //no parameter constructor
    public StackD()
    {
        //queue yapisi linkedlist ile implement edilir
        queue = new LinkedList<E>();
    }

    /**
     *
     * @param item
     */
    @Override
    public void push(E item)
    {

        Queue<E> tempQ = new LinkedList<E>();

        if (queue.size() == 0)
            queue.add(item);
        else
        {
            //queuenun tum elemanlari remove ediliyor remove edilirken de
            //tempQya ekleniyor.queue üzerinde linked list methodlari kullanılıyor
            int tempSize = queue.size();
            for (int i = 0; i < tempSize; i++) {
                E e=queue.remove();
                tempQ.add(e);
            }

            queue.add(item);
            //tempQ uzerindeki tum elemanlar bizim linkedlistimize ekleniyor
            for (int i = 0; i < tempSize; i++)
                queue.add(tempQ.remove());

        }
    }

    /**
     *
     * @return
     */
    @Override
    public E pop()
    {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return queue.remove();
    }


    /**
     *
     * @return
     */
    @Override
    public int size() {
        return queue.size();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return queue.size() == 0 ;
    }

    /**
     *
     * @return
     */
      @Override
    public String toString(){

        return queue.toString().replace('[', ' ').replace(']',' ');
    }
}
