package PART2;

import java.io.*;

public class main2 {

    public static void main(String[] args) {

        HuffmanTree Htree = new HuffmanTree();

        String tempLine;
        String line = "";
        String[] temp1 = null;
        int fileSize=0;

        //dosyanin size'ini belirlemek icin
        try {

            //input file
            //freq.txt input file
            String fileName = "freq.txt";
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //test.txt dosya okuma
            while ((tempLine = bufferedReader.readLine()) != null) {
                ++fileSize;
            }
            //close files.
            bufferedReader.close(); //close input file

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '");
        } catch (IOException ex) {
        }

        HuffmanTree.HuffData[] symbols = new HuffmanTree.HuffData[fileSize];


        try {
            int i=0;
            //input file
            //freq.txt input file
            String fileName = "freq.txt";
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //test.txt dosya okuma
            while ((tempLine = bufferedReader.readLine()) != null) {

                line = tempLine;

                temp1 = line.split(" ");
                Character ch= temp1[0].charAt(0);
                symbols[i]= new HuffmanTree.HuffData(Integer.parseInt(temp1[1]), ch);
                ++i;

            }
            //close files.
            bufferedReader.close(); //close input file

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '");
        } catch (IOException ex) {
        }


        // Build hufffman tree
        Htree.buildTree(symbols);

        // Print huffman codes of the symbols
        Htree.toString();


        // Decode huffman codes to symbols
        String code = "10000000001001100101010";
        String decodedCode = Htree.decode(code);
        System.out.println("Code to Message : \n"+code+" : \t"+decodedCode);

        //decodedCode =Htree.encode(decodedCode);

       //System.out.println(decodedCode);

    }

}


