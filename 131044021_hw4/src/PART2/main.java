package PART2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class main {

    public static void main(String[] args) throws IOException {

        //test.txt input dosyasi
        String fileName = "test.csv";

        String tempLine;
        String line="";
        String[] temp1=null;

        //Queue
        myQueue<String> queue = new myQueue<String>();
        Queue<String> queue1= new LinkedList<String>();


        //input dosya okumasi
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            File file1 = new File("testResult_2.csv");

            FileWriter fileWriter1 = new FileWriter(file1, false);
            BufferedWriter bWriter1 = new BufferedWriter(fileWriter1);



            //test.csv dosya okuma
            while((tempLine = bufferedReader.readLine()) !=null) {
                line = tempLine;

                ///////part1/////////////////
                temp1 = line.split(",");
                for (int j = 0; j < temp1.length; j++) {
                    queue.offer(temp1[j]);
                    bWriter1.write(queue.get(j) + ", ");
                }

                queue.reverse(queue);
                bWriter1.write("\n");

                for (int i = 0; i < temp1.length; i++) {
                    bWriter1.write(queue.get(i) + ", ");

                }
                bWriter1.write("\n");

                for (int i = 0; i < temp1.length; i++) {
                    queue.poll();
                }

                ////////part2
                temp1 = line.split(",");
                for (int j = 0; j < temp1.length; j++) {
                    queue1.add(temp1[j]);

                }

                bWriter1.write(queue1.toString().substring(1,queue1.toString().length()-1) + ", ");
                bWriter1.write("\n");

                queue.reverseQueue(queue1);

                bWriter1.write(queue1.toString().substring(1,queue1.toString().length()-1) + ", ");
                for (int i = 0; i < temp1.length; i++) {
                    queue1.poll();
                }

                bWriter1.write("\n");


            }

            //close files.
            bufferedReader.close();
            bWriter1.close();

        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" );
        }
        catch(IOException ex) {
            System.out.println("Error reading file '");
        }

    }
}


