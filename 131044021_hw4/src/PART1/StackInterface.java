package PART1;

public interface StackInterface<E> {

    /**
     * Adds the given item to the top of the stack.
     */
    void push(E item);

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the stack is empty.
     */
    E pop();


    /**
     *
     * @return
     */
    int size();

    /**
     *  Stack empty or not
     * @return
     */
    boolean isEmpty();


}
