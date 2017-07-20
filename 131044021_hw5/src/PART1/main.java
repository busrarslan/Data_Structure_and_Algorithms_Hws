package PART1;


import java.io.*;
import java.util.Iterator;
import java.util.Stack;

public class main {

    public static void main(String[] args) {

        BinaryTree<Integer> tree= new BinaryTree<>();
        BinarySearchTree<Integer>  searchTree= new BinarySearchTree<Integer>();
        /*tree.root = new BinaryTree.Node(4);
        tree.root.left = new BinaryTree.Node(2);
        tree.root.right = new BinaryTree.Node(5);
        tree.root.left.left = new BinaryTree.Node(1);
        tree.root.left.right = new BinaryTree.Node(3);*/


        String tempLine;
        String line="";
        String[] temp1=null;

        try {
            //input file
            //test.txt input file
            String fileName = "test.txt";
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //test.txt dosya okuma
            while ((tempLine = bufferedReader.readLine()) != null)
            {

                line = tempLine;

                temp1 = line.split(" ");
                for(int i=0; i<temp1.length; i++) {
                    //Binary Tree eleman ekleme
                    tree.insert(new BinaryTree.Node(temp1[i]));
                    //Binary Search Tree eleman ekleme
                    searchTree.add(Integer.parseInt(temp1[i]));
                }

            }
            //close files.
            bufferedReader.close(); //close input file
        }
        catch(FileNotFoundException ex){
            System.out.println("Unable to open file '");
        }
        catch(IOException ex) {
        }


        Iterator itr = tree.iterator();
        System.out.println("1. kısım preorder");
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        System.out.println("2. kısım BinarySearchTree levelorder");
        itr = searchTree.levelOrderiterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }



    }
}
