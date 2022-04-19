package heap;

public interface MyHeap<T> {
    void add(T item);
    T removeRoot();
    boolean remove(T item);
    void heapify();
}
