package PART1;


public class main1 {
    public static void main(String[] args) {
        BinaryHeap<Integer> heap= new BinaryHeap<>();

        heap.insert(20);
        heap.insert(56);
        heap.insert(33);
        heap.insert(46);
        heap.insert(5);
        heap.insert(13);
        heap.insert(88);
        heap.insert(17);
        heap.insert(12);


        System.out.println("preorder binary heap frequentFlyerMax'a Gore");
        System.out.print(heap.print());


    }
}



