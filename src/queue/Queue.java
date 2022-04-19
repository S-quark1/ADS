package queue;

public interface Queue<T> {
    boolean empty();
    int size();
    T peek();
    T enqueue(T item);
    T dequeue();
}
