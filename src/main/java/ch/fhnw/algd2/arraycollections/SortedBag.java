package ch.fhnw.algd2.arraycollections;

import java.util.Arrays;

public class SortedBag<E extends Comparable<? super E>> extends AbstractArrayCollection<E> {
    public static final int DEFAULT_CAPACITY = 100;
    private E[] data;
    private int size;

    public SortedBag() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public SortedBag(int capacity) {
        data = (E[]) new Comparable[capacity];
    }

    public static void main(String[] args) {
        SortedBag<Integer> bag = new SortedBag<Integer>();
        bag.add(2);
        bag.add(1);
        System.out.println(Arrays.toString(bag.toArray()));
    }

    @Override
    public boolean add(E e) {
        // done implement unless collection shall be immutable
        checkNull(e);
        if (size < data.length) {
            //find correct position for e
            int insertIndex = 0;
            while (insertIndex < size && data[insertIndex].compareTo(e) < 0) {
                insertIndex++;
            }
            //shift everything right
            for (int i = size; i > insertIndex; i--) {
                data[i] = data[i - 1];
            }
            //insert into array
            data[insertIndex] = e;
            size++;
            return true;
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean remove(Object o) {
        checkNull(o);
        int removeIndex = indexOf(o);
        if (removeIndex == -1) {
            return false;
        }
        if (removeIndex == size - 1) {
            data[removeIndex] = null;
            size--;
            return true;
        }

            for (int i = removeIndex; i < size-1; i++) {
                data[i] = data[i+1];
            }
            data[size-1] = null;
            size--;
            return true;
        }
        // done implement unless collection shall be immutable
        //throw new UnsupportedOperationException();


    @Override
    public boolean contains(Object o) {
        // done must be implemented
        checkNull(o);
        return indexOf(o) != -1;
        //throw new UnsupportedOperationException();
    }

    private int indexOf(Object o) {
        int i = 0;
        while (i < size && !data[i].equals(o)) {
            i++;
        }
        if (i == size) {
            return -1;
        }
        return i;
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
