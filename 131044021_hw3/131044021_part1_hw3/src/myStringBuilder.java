

import java.util.Iterator;



public final class myStringBuilder
{
    private SingleLinkedList<Character> characterBuffer= new SingleLinkedList<Character>();

    private int capacity;

    /**
     *
     */
    public myStringBuilder(){

    }

    /**
     *
     * @param str
     */
    public myStringBuilder(SingleLinkedList<Integer>  str){
        for(int i=0; i < str.getSize(); i++)
        {
            characterBuffer.add(str.get(i).toString().charAt(0));
        }
    }


    /**
     *
     * @param i
     * @return
     */
    public myStringBuilder append(char i) {
        characterBuffer.add(i);
        return this;
    }


    /**
     *
     * @return
     */
    public String toString1() {
        String result="";
        int i=0;
        while(i<characterBuffer.getSize()){
            result+=(characterBuffer.get(i)) ;
            result+= "\n";
            ++i;
        }

        return result;
    }

    /**
     *
     * @return
     */
    public String toString2() {
        return characterBuffer.toString();
    }

    /**
     *
     * @return
     */
    public String toString3() {
        Iterator iter=characterBuffer.iterator();
        String result="";
        while (iter.hasNext())
        {
            result+=iter.next().toString();
            result+="\n";
        }
        return result;
    }



}
