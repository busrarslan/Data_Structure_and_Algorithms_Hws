import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLService;

import java.io.*;
import java.util.*;

public abstract class AbstractGraphExtended extends AbstractGraph {

    public AbstractGraphExtended(int numV, boolean directed)
    {
        super(numV,directed);
    }


    /////////////////////////////////////////////////////////////////////
    public int addRandomEdgesToGraph (int edgeLimit)
    {
        int insertEdgeNum=0;

        for(int i=0; i< getNumV(); i++)
        {
            for(int j=0; j< getNumV(); j++)
            {
                //edge yoksa eklenecek
                if(i != j) {
                    if (isEdge(i, j) == false && insertEdgeNum < edgeLimit - 1) {
                        insert(getEdge(i, j));

                        ++insertEdgeNum;
                    }
                }
            }
        }

        return insertEdgeNum;
    }
    /////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////////////////////
    //gelen graph objesi uzerinde calisir
    public int [] breadthFirstSearch (int start)
    {
        Queue< Integer > theQueue = new LinkedList< Integer >();
        // Declare array parent and initialize its elements to –1.
        int[] parent = new int[getNumV()];
        for (int i = 0; i < getNumV(); i++) {
            parent[i] = -1;
        }
        // Declare array identified and
        // initialize its elements to false.
        boolean[] identified = new boolean[getNumV()];
        /* Mark the start vertex as identified and insert it
           into the queue */
            identified[start] = true;
            theQueue.offer(start);
        /* While the queue is not empty */
        while (!theQueue.isEmpty()) {
              /* Take a vertex, current, out of the queue.
               (Begin visiting current). */
            int current = theQueue.remove();
              /* Examine each vertex, neighbor, adjacent to current. */
            Iterator < Edge > itr = edgeIterator(current);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                int neighbor = edge.getDest();
                // If neighbor has not been identified
                if (!identified[neighbor]) {
                    // Mark it identified.
                    identified[neighbor] = true;
                    // Place it into the queue.
                    theQueue.offer(neighbor);
          /* Insert the edge (current, neighbor)
             into the tree. */
                    parent[neighbor] = current;
                }
            }
                // Finished visiting current.
        }
        return parent;
    }
    ////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////
    public Graph [] getConnectedComponentUndirectedGraph()
    {

        
        //sadece undirected(yonsuzler icin calisacaktir)
        if(isDirected()== false){


                List<Integer> arrNeighbour = new ArrayList<>();
                for(int i=0; i<getNumV();i++)
                {
                    arrNeighbour.add(0);
                }
            Graph [] graphList= new ListGraph[getNumV()];
                int classes=1;
                for(int i=0; i<getNumV();i++)
                {
                    if(arrNeighbour.get(i)==0)
                    {
                       for(int j=i+1; j< getNumV();j++)
                       {
                           if(isEdge(i,j))
                           {

                               arrNeighbour.set(j,classes);
                               graphList[classes-1] = new ListGraph(getNumV(),false);
                               graphList[classes-1].insert(new Edge(i,j));
                               for(int k=j+1; k< getNumV();k++) {
                                   if (isEdge(j, k)) {
                                       arrNeighbour.set(k,classes);
                                       graphList[classes-1].insert(new Edge(j,k));
                                   }
                               }

                           }
                       }
                       arrNeighbour.set(i,classes);
                        classes++;
                    }

                }
                return graphList;

        }
        else
            return null;
    }
    /////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////
    public boolean isBipartiteUndirectedGraph()
    {
        int vertexNum=getNumV();
        int arrForColor[] = new int[vertexNum];
        for (int i=0; i<vertexNum; ++i)
            arrForColor[i] = -1;

        //ilk deger ataması yapildi
        arrForColor[0] = 1;

        //nodelar birar integer sayi olarak alindi
        //First In First Out
        Queue<Integer>queueList = new LinkedList<>();
        queueList.add(0);

       //size 0 olana kadar bir dongoye sokuldu
        while( queueList.size() != 0)
        {
            int u = queueList.poll();
            int v=0;

            //vertex sayisi getNumV'den kucuk oldugu surece dongu devam eder
            while(v< vertexNum)
            {
                if (isEdge(u,v) && arrForColor[v]==arrForColor[u]) {
                    return false;
                }
                else if (isEdge(u,v) && arrForColor[v]==-1)
                {
                    arrForColor[v] = 1-arrForColor[u];
                    queueList.add(v);
                }

                ++v;
            }
        }

        return true;
    }


    /////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////
    public void writeGraphToFile (String fileName)
    {

        try {

            //output file
            File file1 = new File(fileName);

            FileWriter fileWriter = new FileWriter(file1, false);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);


            bWriter.write(getNumV() +"\n");
            for(int i=0; i< getNumV(); i++)
            {
                for(int j=0; j< getNumV(); j++)
                {
                    if (isEdge(i, j) == true) {
                        bWriter.write(i + " " + j + "\n");
                    }
                }
            }

            //close files.
            bWriter.close();//close output file
        }
        catch(FileNotFoundException ex){
            System.out.println("Unable to open file '");
        }
        catch(IOException ex){
            System.out.println("Error reading file '");
        }

    }
    /////////////////////////////////////////////////////////////////////

}
