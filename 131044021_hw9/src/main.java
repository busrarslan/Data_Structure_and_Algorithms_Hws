import java.io.*;
import java.util.Scanner;

public class main {

    public static void main(String args[]) throws IOException {

        File graphData = new File("ExampleIGraphInputOrOutputFile.txt");
        Scanner scnr = new Scanner(graphData);

        //simdi dosyadan okuyup ListGraph objesine kaydedelim
        ListGraph lgObj = (ListGraph) AbstractGraph.createGraph(scnr, true, "List");


        //Method 1 test ediyoruz ve sonucu dosyaya yazıyoruz.//////////
        //return edilen eklenen edge sayisi
        int addEdgeNum=0;
        addEdgeNum=lgObj.addRandomEdgesToGraph(10);
        System.out.println("addRandomEdgesToGraph methodu_1 \neklenen edge sayisi: " + addEdgeNum);
        lgObj.writeGraphToFile("graph_addRandomEdgeGraph_out_m1_1.txt");

        File graphData9 = new File("denemeInput2.txt");
        Scanner scnr9 = new Scanner(graphData9);

        //simdi dosyadan okuyup ListGraph objesine kaydedelim
        ListGraph lgObj9 = (ListGraph) AbstractGraph.createGraph(scnr9, true, "List");
        int addEdgeNum1=0;
        addEdgeNum1=lgObj9.addRandomEdgesToGraph(5);
        System.out.println("addRandomEdgesToGraph methodu_2 \neklenen edge sayisi: " + addEdgeNum1);
        lgObj9.writeGraphToFile("graph_addRandomEdgeGraph_out_m1_2.txt");





        //Method 2///////////////////////////////////////////////////////////
        File graphData10 = new File("ExampleIGraphInputOrOutputFile.txt");
        Scanner scnr10 = new Scanner(graphData10);

        //simdi dosyadan okuyup ListGraph objesine kaydedelim
        ListGraph lgObj10 = (ListGraph) AbstractGraph.createGraph(scnr10, true, "List");
        //return edilen arayin elemanlari console 'a bastirildi
        int[] result2 = lgObj10.breadthFirstSearch(2);

        System.out.print("breadthFirstSearch method test_1 :   ");
        for (int i=0; i<result2.length; i++)
            System.out.print(result2[i]+ " ");

        System.out.print("\n");

        //////////////////////////////////////////////////////////////////
        //return edilen arayin elemanlari console 'a bastirildi
        int[] result = lgObj9.breadthFirstSearch(2);

        System.out.print("breadthFirstSearch method test_2 :   ");
        for (int i=0; i<result.length; i++)
            System.out.print(result[i]+ " ");

        System.out.print("\n");


        //Method 3//////////////////////////////////////////////////////////
        File graphData3 = new File("denemeInput2.txt");
        Scanner scnr3 = new Scanner(graphData3);

        //simdi dosyadan okuyup ListGraph objesine kaydedelim
        ListGraph lgObj6 = (ListGraph) AbstractGraph.createGraph(scnr3, false, "List");

        ListGraph[] testList=(ListGraph [])lgObj6.getConnectedComponentUndirectedGraph();

        int m=1, y=0;
        int k=testList.length;
        while(k > 0){
            if(testList[y]!=null) {
                testList[y].writeGraphToFile("graph_getConnectedComponent_out_graph" + m + ".txt");
                y++;
                ++m;

            }
            --k;
        }


        //Method 4//////////////////////////////////////////////////////////
        File graphData1 = new File("denemeInput1.txt");
        Scanner scnr1 = new Scanner(graphData1);

        //simdi dosyadan okuyup ListGraph objesine kaydedelim
        ListGraph lgObj1= (ListGraph) AbstractGraph.createGraph(scnr1, false, "List");

        boolean isBipartite;
        isBipartite=lgObj1.isBipartiteUndirectedGraph();
        System.out.println("isBipartiteUndirectedGraph method test1 : " + isBipartite);


        File graphData2 = new File("ExampleIGraphInputOrOutputFile.txt");
        Scanner scnr2 = new Scanner(graphData2);
        ListGraph lgObj2= (ListGraph) AbstractGraph.createGraph(scnr2, false, "List");

        isBipartite=lgObj2.isBipartiteUndirectedGraph();
        System.out.println("isBipartiteUndirectedGraph method test2 : " + isBipartite);


    }
}
