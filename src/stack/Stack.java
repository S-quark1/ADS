package stack;

public interface Stack<T> {
    boolean empty();
    int size();
    T peek();
    T push(T item);
    T pop();
}
