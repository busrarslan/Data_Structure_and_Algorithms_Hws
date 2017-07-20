package PART3;

import java.util.LinkedList;

public class priorityQueueA<E> extends LinkedList<E> {

    /**
     *
     */
    public priorityQueueA(){
        super();
    }

    /**
     *
     * @param a
     * @return
     */
    public int size(priorityQueueA<E> a) {
        return a.size();
    }

    /**
     *
     * @return
     */
    public boolean isEmpty(){
        return size()==0;
    }

    /**
     *
     * @param l
     */
    public void deleteMin(LinkedList<E> l)
    {
        int[] ascii=new int[l.size()];
        for (int i = 0; i < l.size(); i++)
        {
            String list=(String)l.get(i);
            char character = list.charAt(0);
            ascii[i] = (int) character;

        }

        int asciiMin=ascii[0];
        int minSize=0;
        for(int j=0; j< l.size(); j++){
            if(asciiMin >= ascii[j]) {
                asciiMin = ascii[j];
                minSize=j;
            }
        }

        l.remove(minSize);
    }


    /**
     *
     * @param e
     */
    public void insert(E e){
        add(e);
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
