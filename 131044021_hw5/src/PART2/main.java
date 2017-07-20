package PART2;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class main {

    public static void main(String[] args) {
        FamilyTree<String> tree= new FamilyTree<String>();

        String tempLine;
        String line="";
        String[] temp1=null;

        try {
            //input file
            //family.txt input file

            String fileName = "family.txt";
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int k=0;
            //test.txt dosya okuma
            while ((tempLine = bufferedReader.readLine()) != null )
            {
                line = tempLine;
                if(k==0) {
                    tree = new FamilyTree(line);
                    //System.out.println(tree);
                }
                else {
                    temp1 = line.split(", ");

                    tree.add(temp1[0], temp1[1], temp1[2]);
                    k++;

                }
                k=1;

            }

            //close files.
            bufferedReader.close(); //close input file
        }
        catch(FileNotFoundException ex){
            System.out.println("Unable to open file '");
        }
        catch(IOException ex) {
        }

       /* Iterator it= tree.iterator();
        while(it.hasNext()){
            System.out.println(it.next() +" ");
        }*/

       System.out.println(tree);


    }
}

