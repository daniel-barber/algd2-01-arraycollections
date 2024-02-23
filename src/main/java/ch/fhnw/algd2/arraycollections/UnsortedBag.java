package ch.fhnw.algd2.arraycollections;

import java.util.Arrays;

public class UnsortedBag<E> extends AbstractArrayCollection<E> {
    public static final int DEFAULT_CAPACITY = 100;
    private E[] data;
    private int size = 0;

    public UnsortedBag() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public UnsortedBag(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public static void main(String[] args) {
        UnsortedBag<Integer> bag = new UnsortedBag<Integer>();
        bag.add(2);
        bag.add(1);
        System.out.println(Arrays.toString(bag.toArray()));
    }

    @Override
    public boolean add(E e) {
        // done implement unless collection shall be immutable
        checkNull(e);
        if(size==data.length){
            throw new IllegalStateException();
        }
        data[size++] = e;
        return true;
        //throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        // done implement unless collection shall be immutable
        checkNull(o);
        int index = indexOf(o);
        if (index == -1){
            return false;
        }
        data[index] = data[size-1];
        data[size-1] = null;
        size--;
        return true;
        //throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        // done must be implemented
        checkNull(o);
        return indexOf(o) != -1;
        //throw new UnsupportedOperationException();
    }

    private int indexOf(Object o) {
        int current = 0;
        while (current < size && !data[current].equals(o)) {
            current++;
        }
        if (current == size) {
            return -1;
        } else {
            return current;
        }
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size());
    }

    @Override
    public int size() {
        // done must be implemented
        return size;
    }
}
