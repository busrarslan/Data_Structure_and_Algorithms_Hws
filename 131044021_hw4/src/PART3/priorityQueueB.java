package PART3;

import java.util.LinkedList;

public class priorityQueueB<E> {
    //composition

    private LinkedList<E> linkedList=new LinkedList<E>();

    /**
     *
     * @return
     */
    public int size(){
        return linkedList.size();
    }

    /**
     *
     * @return
     */
    public boolean isEmpty(){
        return linkedList.size()==0;
    }

    /**
     *
     */
    public void deleteMin()
    {
        int[] ascii=new int[linkedList.size()];
        for (int i = 0; i < linkedList.size(); i++)
        {
            String list=(String)linkedList.get(i);
            char character = list.charAt(0);
            ascii[i] = (int) character;

        }

        int asciiMin=ascii[0];
        int minSize=0;
        for(int j=0; j<linkedList.size(); j++){
            if(asciiMin >= ascii[j]) {
                asciiMin = ascii[j];
                minSize=j;
            }
        }

        linkedList.remove(minSize);

    }

    /**
     *
     * @param e
     */
    public void insert(E e){
        linkedList.add(e);

    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return  linkedList.toString().replace('[', ' ').replace(']',' ');
    }
}
