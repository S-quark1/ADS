package heap;

import lists.MyArrayList;

public class MaxHeap<T extends Comparable<T>> implements MyHeap<T> {
    private MyArrayList<T> heap;

    public MaxHeap() {
        heap = new MyArrayList<>();
    }

    @Override
    public void add(T item) {
        heap.add(item);
        heapify();
    }

    @Override
    public T removeRoot() {
        if (heap.size() == 0)
            throw new IndexOutOfBoundsException("heap is empty!");
        T temp = heap.get(0);
        heap.swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        heapify();
        return temp;
    }

    @Override
    public boolean remove(T item) {
        for (int i = 0; i < heap.size(); i++) {
            if (heap.get(i) == item) {
                heap.swap(i, heap.size() - 1);
                heap.remove(heap.size() - 1);
                heapify();
                return true;
            }
        }
        return false;
    }

    @Override
    public void heapify() {
        for (int i = heap.size() / 2; i >= 0; --i) {
            maxHeapify(i);
        }
    }

    private void maxHeapify(int i) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest;
        if (l < heap.size() && heap.get(l).compareTo(heap.get(i)) > 0) {
            largest = l;
        } else largest = i;
        if (r < heap.size() && heap.get(r).compareTo(heap.get(i)) > 0) {
            if (heap.get(r).compareTo(heap.get(l)) > 0) largest = r;
        }
        if (largest != i) {
            heap.swap(i, largest);
            maxHeapify(largest);
        }
    }

    public void printAll() {
        if (heap.size() == 0)
            throw new IndexOutOfBoundsException("heap is empty!");
        int j = 1;
        int k = 2;
        int temp = 1;
        System.out.println("*********************************");
        while (k <= heap.size()){
            for (int i = temp; i < k; i++) {
                System.out.print(heap.get(i-1) + " ");
            }
            temp = k;
            k = (int) Math.pow(2, ++j);
            System.out.println();
        }
        for (int i = temp; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println("\n*********************************");
    }

//    private void traverseDown() {
//        int current = 0;
//        while (current < heap.size()) {
//            int left = current * 2 + 1;
//            int right = current * 2 + 2;
//            if (left < heap.size()) {
//                int max = left;
//                if (right < heap.size()) {
//                    if (heap.get(right).compareTo(heap.get(left)) > 0) {
//                        max = right;
//                    }
//                }
//                if (heap.get(max).compareTo(heap.get(current)) > 0) {
//                    heap.swap(current, max);
//                    current = max;
//                } else break;
//            } else break;
//        }
//    }
//
//    private void traverseUp() {
//        int current = heap.size() - 1;
//        while (current > 0) {
//            int parent = (current - 1) / 2;
//            if (heap.get(current).compareTo(heap.get(parent)) > 0) {
//                heap.swap(current, parent);
//                current = parent;
//            } else break;
//        }
//    }
}
