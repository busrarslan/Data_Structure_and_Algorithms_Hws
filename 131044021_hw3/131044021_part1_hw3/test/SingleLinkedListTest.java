import javax.xml.soap.Node;
import java.util.LinkedList;


import static org.junit.Assert.*;

/**
 * Created by bs on 14.3.2017.
 */
public class SingleLinkedListTest {


    @org.junit.Test
    public void getSize() throws Exception {
        SingleLinkedList<Integer> forTest1 =new SingleLinkedList<Integer>();
        int size=5;


        assertEquals(size,5);
    }

    @org.junit.Test
    public void get() throws Exception {
        SingleLinkedList<Integer> forTest1 =new SingleLinkedList<Integer>();

    }

    @org.junit.Test
    public void set() throws Exception {

    }

    @org.junit.Test
    public void add() throws Exception {
        SingleLinkedList<Integer> forTest1 =new SingleLinkedList<Integer>();
        SingleLinkedList<Integer> forTest2 =new SingleLinkedList<Integer>();
        forTest1.add(1);
        int a=0, b=0;
        forTest2.add(1);


        assertEquals(a,b);

    }


    @org.junit.Test
    public void addFirst() throws Exception {
        SingleLinkedList<Integer> forTest1 =new SingleLinkedList<Integer>();
        SingleLinkedList<Integer> forTest2 =new SingleLinkedList<Integer>();
        forTest1.add(1);
        int a=0, b=0;
        forTest2.add(1);


        assertEquals(a,b);

    }

}