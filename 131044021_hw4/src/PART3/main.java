package PART3;

import java.io.*;

public class main {

    public static void main(String[] args){

        priorityQueueA<String> priorityA=new priorityQueueA<String>();
        priorityQueueB<String> priorityB=new priorityQueueB<String>();


        String tempLine;
        String line="";
        String[] temp1=null;



        try {
            //input file
            //test.txt input file
            String fileName = "test.csv";
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //output file
            File file1 = new File("testResult_3.csv");

            FileWriter fileWriter1 = new FileWriter(file1, false);
            BufferedWriter bWriter1 = new BufferedWriter(fileWriter1);

            //test.csv dosya okuma
            while ((tempLine = bufferedReader.readLine()) != null)
            {
                line = tempLine;


                temp1 = line.split(",");
                for (int j = 0; j < temp1.length; j++) {
                    priorityA.insert(temp1[j]);
                    priorityB.insert(temp1[j]);
                }

                /////////////////////////////////TEST1-StackA/////////////////////////////////////////
                bWriter1.write(priorityA.toString().substring(1,priorityA.toString().length()-1) + "\n");
                priorityA.deleteMin(priorityA);
                bWriter1.write(priorityA.toString().substring(1,priorityA.toString().length()-1) + "\n");


                for (int j = 0; j < temp1.length-1; j++) {
                    priorityA.deleteMin(priorityA);
                }

                /////////////////////////////////TEST1-StackB/////////////////////////////////////////
                bWriter1.write(priorityB.toString().substring(1,priorityB.toString().length()-1) + "\n");
                priorityB.deleteMin();
                bWriter1.write(priorityB.toString().substring(1,priorityB.toString().length()-1) + "\n");

                for (int j = 0; j < temp1.length-1; j++) {
                    priorityB.deleteMin();
                }

            }
            //close files.
            bWriter1.close();//close output file
            bufferedReader.close(); //close input file
        }
        catch(FileNotFoundException ex){
            System.out.println("Unable to open file '");
        }
        catch(IOException ex){
            System.out.println("Error reading file '");
        }

    }

}



