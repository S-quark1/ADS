package lists;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] arr;
    private int length = 0;
    private int capacity = 3;

    public MyArrayList() {
        arr = new Object[capacity];
    }


    public void add(T item) {
        if (length == capacity)
            increaseCapacity();

        arr[length++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (index > length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less or equal to size!");
        if (length == capacity)
            increaseCapacity();
        length++;
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
    }

    @Override
    public boolean remove(T item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(item)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size!");
        Object a = arr[index];
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        length--;
        return (T) a;
    }

    @Override
    public void clear() {
        for (int i = 0; i < arr.length; i++) {
            remove(i);
        }
        length = 0;
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    public T get(int index) {
        return (T) arr[index];
    }

    @Override
    public int indexOf(Object o) {
//        if (!contains(o)) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = length - 1; i >= 0; i--) {
            if (arr[i].equals(o)) return i;
        }
        return -1;
    }

    public void swap(int curr, int next){
        Object temp = arr[curr];
        arr[curr] = arr[next];
        arr[next] = temp;
    }

    @Override
    public void sort() {
        for (int i = 0; i < length; i++) {
            int counter = 0;
            for (int j = i; j < length - 1; j++) {
                T a = (T)arr[j];
                T b = (T)arr[j+1];
                if (a.compareTo(b) > 0) {
                    counter++;
                    swap(j, j+1);
                }
            }
            if (counter == 0) break;
        }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for (Object value : arr) {
            if (value.equals(o)) return true;
        }
        return false;
    }
}
