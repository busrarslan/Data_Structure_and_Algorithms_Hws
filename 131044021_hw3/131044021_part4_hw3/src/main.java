import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        SingleLinkedList<Integer> numbersList = new SingleLinkedList<Integer>();
        SingleLinkedList<Integer> tempList = new SingleLinkedList<Integer>();

        try {
            Scanner s = new Scanner(new File("number_ilk_okunan.txt"));

            while (s.hasNext()) {
                if (s.hasNextInt()) {
                    numbersList.add(s.nextInt());
                }
            }
            //close file
            s.close();

        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '");
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbersList.getSize(); i++) {
            stringBuilder.append(numbersList.get(i).toString().charAt(0));
        }

        System.out.println("100 eleman ile single linkedlist olusturuldu: ");
        System.out.println(stringBuilder.toString());

        int a= numbersList.getSize();

        for (int i =0; i <=50; i++) {
            numbersList.remove(a);
            a--;
        }

        //System.out.println(numbersList.deletedToString());

        System.out.println("50 eleman silindiginde single linkedlistde kalan elemanlar: ");
        for(int i=0; i<numbersList.getSize();++i){
            System.out.print(numbersList.get(i));

        }

        System.out.print("\n\n\n");


        //100 eleman eklemek istersek
        //numbersList'in icinde silindikten sonra kalan list var.
        //silinenler ilk eklenecek.
        //sonra silinenler listesi bitince yeni tempList eklenecek.

        try {
            Scanner s1 = new Scanner(new File("2_kez_okunan.txt"));

            while (s1.hasNext()) {
                if (s1.hasNextInt()) {
                    tempList.add(s1.nextInt());
                }
            }
            //close file
            s1.close();

        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '");
        }


        System.out.println("Silinen elemanlar deletedToString'in içinde tutuluyor: ");
        int size=100;
        for (int i = 0; i < size; i++) {

            numbersList.add(tempList.get(i));

            if (i == 50) {
                int ii = 0;
            }

            System.out.print(numbersList.deletedToString());

        }

        System.out.print("\n\n\n");

        System.out.println("Tekrar 100 eleman single linkedliste eklendiginde: ");
        for(int i=0; i < numbersList.getSize();i++)
            System.out.print(numbersList.get(i));

        System.out.println("\n\ncikarilan 50 eleman nodelar seklinde tutuldu. 100 eleman eklenmek istendiginde: ");
        System.out.println("ilk once deleteToString deki 50 eleman eklendi sonra ekstra dosyadan okunan 100 elemandan: ");
        System.out.println("50 si eklenerek 2. kez 100 eleman eklenmis oldu.: ");



    }
}

