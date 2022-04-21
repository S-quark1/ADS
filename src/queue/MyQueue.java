package queue;

import lists.MyLinkedList;

public class MyQueue<T extends Comparable<T>> implements Queue<T> {
    private MyLinkedList<T> queue;

    public MyQueue() {
        queue = new MyLinkedList<T>();
    }

    @Override
    public boolean empty() {
        return queue.size() == 0;
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public T peek() {
        return queue.get(0);
    }

    @Override
    public T enqueue(T item) {
        queue.add(item);
        return item;
    }

    @Override
    public T dequeue() {
        if (empty())
            throw new IndexOutOfBoundsException("Queue is empty!");
        return queue.remove(0);
    }
}
