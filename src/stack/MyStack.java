package stack;

import lists.MyLinkedList;

public class MyStack<T extends Comparable<T>> implements Stack<T>{
    private MyLinkedList<T> stack;

    public MyStack() {
        stack = new MyLinkedList<T>();
    }
    @Override
    public boolean empty() {
        return stack.size() == 0;
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public T peek() {
        return stack.get(0);
    }

    @Override
    public T push(T item) {
        stack.add(item, 0);
        return item;
    }

    @Override
    public T pop() {
        if (empty())
            throw new IndexOutOfBoundsException("Stack is empty!");
        return stack.remove(0);
    }
}
