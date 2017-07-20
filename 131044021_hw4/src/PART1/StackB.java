package PART1;

import java.util.ArrayList;

public class StackB<E> implements StackInterface<E> {

    //composition ilişkisi
    private ArrayList<E> list;

    public StackB() {

        list= new ArrayList<E>();
    }

    /**
     *
     * @param item
     */
    @Override
    public void push(E item) {
        list.add(item);
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
            return list.remove(size()-1);
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {

        return list.size();
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
     * @return
     */
    @Override
    public String toString() {

        return list.toString().replace('[', ' ').replace(']', ' ');
    }
}
