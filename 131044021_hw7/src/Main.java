
import java.util.NavigableMap;


public class Main
{
    public static void main(String args[]){
        final Boolean q1 = Q1Test();
        System.out.println("part2");
        final Boolean q2 = Q2Test();
        if (q1 == q2 == Boolean.TRUE) {
            // System.out.println("Your tests is done. Make sure that you test all methods of class!! " );
            return;
        }
     /*  BinarySearchTree<String> b=new BinarySearchTree<>();
       b.add("aaa","bbbb");
        b.add("cccc","xxx");
        System.out.println(b.toString());*/

    }

    public static Boolean Q1Test(){

        NavigableMap<String,String> turkey = new BinaryNavMap<String,String>();
        turkey.put("uskudar","istanbul");
        turkey.put("kadıkoy","istanbul");
        turkey.put("cekirge","bursa");
        turkey.put("gebze","kocaeli");
        turkey.put("niksar","tokat");
        turkey.put("kecıoren","ankara");
        turkey.put("aksaray","istanbul");
        turkey.put("foca","izmir");
        turkey.put("manavgat","antalya");
        turkey.put("kahta","adıyaman");
        turkey.put("biga","canakkale");

        System.out.println("The original set odds is " + turkey);
        NavigableMap<String,String> m = turkey.subMap("uskudar",true,"gebze",false);
        System.out.println("The ordered set m is " + m);
        System.out.println("The first entry is " +turkey.firstEntry());
        System.out.println("The lower entry is " +turkey.lowerEntry("alsaray").getValue());
        System.out.println("The lower key is " +turkey.lowerKey("cursa"));

        System.out.println("The floor key is " +turkey.floorKey("cursa"));
        System.out.println("The floor entry is " +turkey.floorEntry("cursa"));
        System.out.println("The ceilingEntry is " +turkey.ceilingEntry("cursa"));
        System.out.println("The ceilingKey is " +turkey.ceilingKey("cursa"));
        System.out.println("The higherEntry is " +turkey.higherEntry("abıyaman"));
        System.out.println("The higherKey is " +turkey.higherKey("cursa"));
        System.out.println("The lastEntry is " +turkey.lastEntry());
        System.out.println("The pollFirstEntry is " +turkey.pollFirstEntry());
        System.out.println("The pollLastEntry is " +turkey.pollLastEntry());
        System.out.println("The firstKey is " +turkey.firstKey());
        System.out.println("The lastKey is " +turkey.lastKey());



        /* *some links to help you

           https://docs.oracle.com/javase/8/docs/api/java/util/NavigableMap.html
           https://docs.oracle.com/javase/8/docs/api/java/util/AbstractMap.html

        * */
        return Boolean.TRUE;

    }
    public static Boolean Q2Test(){

        HashMap<String,String> turkey=new HashTableChaining<String,String>();

        turkey.put("edremit","balikesir");
        turkey.put("edremit","van");
        turkey.put("kemalpasa","bursa");
        turkey.put("kemalpasa","izmir");
        turkey.put("ortakoy","istanbul");//we assume a district
        turkey.put("ortakoy","aksaray");
        turkey.put("ortakoy","corum");
        turkey.put("kecıoren","ankara");
        turkey.put("pinarbasi","kastamonu");
        turkey.put("pinarbasi","kayseri");
        turkey.put("eregli","konya");
        turkey.put("eregli","tekirdag");
        turkey.put("eregli","zonguldak");
        turkey.put("golbasi","adıyaman");
        turkey.put("golbasi","ankara");
        turkey.put("biga","canakkale");

        /* *test all*/

        System.out.println("get method :" + turkey.get("ortakoy"));

        System.out.println("put method :" + turkey.put("uzungol", "trabzon"));

        System.out.println("remove method :" + turkey.remove("eregli"));

        System.out.println("size method :" + turkey.size());


        return Boolean.TRUE;
    }


}
