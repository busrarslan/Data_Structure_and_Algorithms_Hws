import javax.xml.soap.Node;
import java.io.IOException;



public class main {
    public static void main(String args[])throws IOException {

        SingleLinkedList<String>  list= new SingleLinkedList<String>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        System.out.println("");
        System.out.println("___________________");
        System.out.print("Original SingleLinkedList : ");
        System.out.println(list.reverseToString(list.getHead()));

        list.reverse(list.getHead());
        System.out.print("\nReverse SingleLinkedList  : ");
        System.out.println(list.reverseToString(list.getHead()));
        System.out.println("");


        SingleLinkedList<Integer>  list2= new SingleLinkedList<Integer>();
        list2.add(10);
        list2.add(11);
        list2.add(12);
        list2.add(13);
        list2.add(14);
        list2.add(15);
        System.out.println("");
        System.out.println("___________________");
        System.out.print("Original SingleLinkedList : ");
        System.out.println(list2.reverseToString(list2.getHead()));

        list2.reverse(list2.getHead());
        System.out.print("\nReverse SingleLinkedList  : ");
        System.out.println(list2.reverseToString(list2.getHead()));
        System.out.println("");



    }
}
