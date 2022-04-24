import heap.MaxHeap;
import merge.Mergesort;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer arr[] = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        Mergesort<Integer> f = new Mergesort<>();
        f.MergeSort(arr, 0, arr.length - 1);
        // этот с книжки
        for (Integer a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("\n*****************");
        List<Integer> arr2 = new ArrayList<>(List.of(9, 8, 7, 6, 5, 4, 3, 2, 1));
        f.MergeSortYT(arr2);
        // этот с yt и намного понятнее
        for (Integer a : arr2) {
            System.out.print(a + " ");
        }
        System.out.println("\n*****************");

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
