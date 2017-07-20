package PART1;

import java.util.ArrayList;

public class StackA<E> extends ArrayList<E> implements StackInterface<E> {


    /**
     *
     */
    public StackA() {
        super();
    }

    /**
     *
     * @param item
     */
    @Override
    public void push(E item) {
        add(item);
    }

    /**
     *
     * @return
     */
    @Override
    public E pop()
    {
        if(isEmpty())
            throw new RuntimeException("Stack is empty");
        else
            return remove(size()-1);
    }

    /**
     *
     * @param a
     * @return
     */
    public int size(StackA<E> a) {

        return a.size();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {

        return size()==0;
    }

    /**
     *
     * @param a
     * @return
     */
    public String toString(StackA<E> a) {
        return a.toString().replace('[', ' ').replace(']', ' ');

    }
}
