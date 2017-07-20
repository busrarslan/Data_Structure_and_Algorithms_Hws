//sure hesaplama fonksiyonlari icin bu kaynaktan yararlanilmistir
//http://stackoverflow.com/questions/11770935/java-system-currenttimemillis-not-returning-difference

import java.io.*;

import java.util.Scanner;

public class main {

    public static void main(String args[])throws IOException {


        SingleLinkedList<Integer> numbersList= new SingleLinkedList<Integer>();

        try {
            Scanner s = new Scanner(new File("numbers.txt"));

            while (s.hasNext()){
                if(s.hasNextInt()){
                    numbersList.add(s.nextInt());
                }
            }
            //close file
            s.close();

        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" );
        }


        myStringBuilder stringBuilder= new myStringBuilder();
        for(int i=0;i < numbersList.getSize();i++)
        {
            stringBuilder.append(numbersList.get(i).toString().charAt(0));
        }

        //System.out.println(stringBuilder.toString1());
        //System.out.println("");


        long startTime1 = System.currentTimeMillis();
        //write result1.txt
        try{
            File file = new File("result1.txt");

            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);

            bWriter.write(stringBuilder.toString1());

            bWriter.close();

        } catch (IOException e) {
            System.err.println("Problem writing to the file result1.txt");
        }

        long estimatedTime1 = System.currentTimeMillis() - startTime1;
        System.out.println("Calisma Süresi get and index methods: " + estimatedTime1 + " ms");

        //System.out.println(stringBuilder.toString2());
        // System.out.println("");


        long startTime2 = System.currentTimeMillis();
        //write result2.txt
        try{
            File file = new File("result2.txt");

            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);

            bWriter.write(stringBuilder.toString2());

            bWriter.close();

        } catch (IOException e) {
            System.err.println("Problem writing to the file result2.txt");
        }

        long estimatedTime2 = System.currentTimeMillis() - startTime2;
        System.out.println("Calisma Süresi SingleLinkedList_toString: " + estimatedTime2 + " ms");


        long startTime3 = System.currentTimeMillis();
        //System.out.println(stringBuilder.toString3());
        //write result3.txt
        try{
            File file = new File("result3.txt");

            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);

            bWriter.write(stringBuilder.toString3());

            bWriter.close();

        } catch (IOException e) {
            System.err.println("Problem writing to the file result3.txt");
        }
        long estimatedTime3 = System.currentTimeMillis() - startTime3;
        System.out.println("Calisma Süresi İterator: " + estimatedTime3 + " ms");

    }
}
