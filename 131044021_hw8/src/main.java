//Busra Arslan
//131044021

public class main {
    public static void main(String args[])
    {

        AVLTree<String> avlTree = new AVLTree<>();
        AVLTree<Integer> avlTree2 = new AVLTree<>();
        AVLTree<Character> avlTree3= new AVLTree<>();


        //Kagida yazmali odevin testi
        ///////////////////////////////////////////////////////
        avlTree.add("Nush");
        avlTree.add("ile");
        avlTree.add("uslanmayani");
        avlTree.add("etmeli");
        avlTree.add("tekdir");
        avlTree.add("uslanmayanin");
        avlTree.add("hakki");
        avlTree.add("kotektir");

        //insert
        avlTree.add("edille");
        avlTree.add("dakik");
        avlTree.add("ferc");


        System.out.println("Pre Order Traversal for String type ");
        System.out.println(avlTree.toString());
        avlTree.delete("ile");



        System.out.println("Pre Order Traversal for String type >> After delete method ");
        System.out.println("Root delete edilmistir");
        System.out.println(avlTree.toString());
        //////////////////////////////////////////////////////////////////////////

        //////////////////////////////////////////////////////////////////////////
        avlTree2.add(10);
        avlTree2.add(20);
        avlTree2.add(30);
        avlTree2.add(50);
        avlTree2.add(75);
        avlTree2.add(25);
        avlTree2.add(40);
        avlTree2.add(70);

        System.out.println("Pre Order Traversal for Integer type");
        System.out.println(avlTree2.toString());


        avlTree2.delete(30);

        System.out.println("Pre Order Traversal for Integer type  >> After delete method");
        System.out.println("Root delete edilmistir");
        System.out.println(avlTree2.toString());
        ///////////////////////////////////////////////////////////////////////////////


        ///////////////////////////////////////////////////////////////////////////////
        avlTree3.add('a');
        avlTree3.add('b');
        avlTree3.add('k');
        avlTree3.add('d');
        avlTree3.add('m');
        avlTree3.add('t');
        avlTree3.add('z');
        avlTree3.add('u');


        System.out.println("Pre Order Traversal for Character type");
        System.out.println(avlTree3.toString());

        avlTree3.delete('k');

        System.out.println("Pre Order Traversal for Character type  >> After delete method");
        System.out.println("Root delete edilmistir");
        System.out.println(avlTree3.toString());
        ///////////////////////////////////////////////////////////////////



    }
}

