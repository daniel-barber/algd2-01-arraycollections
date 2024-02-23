package ch.fhnw.algd2.arraycollections;

import java.util.Arrays;
import java.util.Set;

public class SortedSet<E extends Comparable<? super E>> extends AbstractArrayCollection<E> implements Set<E> {
    public static final int DEFAULT_CAPACITY = 100;
    private E[] data;
    private int size;

    public SortedSet() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public SortedSet(int capacity) {
        data = (E[]) new Comparable[capacity];
    }

    public static void main(String[] args) {
        SortedSet<Integer> bag = new SortedSet<Integer>();
        bag.add(2);
        bag.add(2);
        bag.add(1);
        System.out.println(Arrays.toString(bag.toArray()));
    }

    @Override
    public boolean add(E e) {
        // done implement unless collection shall be immutable
        checkNull(e);
        if(contains(e)){return false;}
        if (size == data.length) {
            throw new IllegalStateException();
        }
            int insertIndex = 0;
            //find insertIndex
            while (insertIndex < size && data[insertIndex].compareTo(e) < 0) {
                insertIndex++;
            }
            //shift everything right
            for (int i = size; i > insertIndex; i--) {
                data[i] = data[i - 1];
            }
            //insert e
            data[insertIndex] = e;
            size++;
            return true;
        }

        //throw new UnsupportedOperationException();


    @Override
    public boolean remove(Object o) {
        // done implement unless collection shall be immutable
        checkNull(o);
        if(!contains(o)){
            return false;
        }
        int removeIndex = indexOf(o);
        for(int i=removeIndex;i<size-1;i++){
            data[i]=data[i+1];
        }
        data[size-1]=null;
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
