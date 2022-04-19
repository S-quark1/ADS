import heap.MaxHeap;
import lists.MyArrayList;
import lists.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.add(4);
        heap.add(1);
        heap.add(3);
        heap.add(2);
        heap.add(16);
        heap.add(9);
        heap.add(10);
        heap.add(14);
        heap.add(8);
        heap.add(7);
        heap.printAll();
        System.out.println(heap.remove(16));
        heap.add(34);
        heap.printAll();
        heap.add(4);
        heap.removeRoot();
        heap.printAll();
    }
}
