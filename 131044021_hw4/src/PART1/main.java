package PART1;

import java.io.*;

public class main {

    public static void main(String[] args) throws IOException {

        String tempLine;
        String line="";
        String[] temp1=null;

        //Stacklerimiz
        StackA<String> testStack1 = new StackA<String>();
        StackB<String> testStack2 = new StackB<String>();
        StackC<String> testStack3 = new StackC<String>();
        StackD<String> testStack4 = new StackD<String>();


        try {
            StackA<String> testStack1Temp = new StackA<String>();
            StackB<String> testStack2Temp = new StackB<String>();
            StackC<String> testStack3Temp = new StackC<String>();
            //input file
            //test.txt input file
            String fileName = "test.csv";
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //output file
            File file1 = new File("testResult_1.csv");

            FileWriter fileWriter1 = new FileWriter(file1, false);
            BufferedWriter bWriter1 = new BufferedWriter(fileWriter1);

            //test.csv dosya okuma
            while ((tempLine = bufferedReader.readLine()) != null)
            {
                line = tempLine;


                temp1 = line.split(",");
                for (int j = 0; j < temp1.length; j++) {
                    testStack1Temp.push(temp1[j]);
                    testStack2Temp.push(temp1[j]);
                    testStack3Temp.push(temp1[j]);
                    testStack4.push(temp1[j]);

                }

                for (int j = 0; j < temp1.length; j++) {
                    testStack1.push(testStack1Temp.pop());
                    testStack2.push(testStack2Temp.pop());
                    testStack3.push(testStack3Temp.pop());
                }


                /////////////////////////////////TEST1-PART1.StackA/////////////////////////////////////////
                //output dosyasina yazma
                bWriter1.write(testStack1.size() + ": ");
                bWriter1.write(  testStack1.toString().substring(1,testStack1.toString().length()-1) + "\n");

                /////////////////////////////////TEST2-PART1.StackB/////////////////////////////////////////
                bWriter1.write(testStack2.size() + ":");
                bWriter1.write(testStack2 + "\n");

                /////////////////////////////////TEST3-PART1.StackC/////////////////////////////////////////
                bWriter1.write(testStack3.size() + ":");
                bWriter1.write(testStack3 + "\n");


                /////////////////////////////////TEST4-PART1.StackD/////////////////////////////////////////
                bWriter1.write(testStack4.size() + ":");
                bWriter1.write(testStack4 + "\n");


                //stackteki elemanlari pop edip yeni satir okuma
                for (int j = 0; j < temp1.length; j++) {
                    testStack1.pop();
                    testStack2.pop();
                    testStack3.pop();
                    testStack4.pop();
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
