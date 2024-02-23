package ch.fhnw.algd2.arraycollections;

import java.util.Arrays;
import java.util.Set;

public class UnsortedSet<E> extends AbstractArrayCollection<E> implements Set<E> {
    public static final int DEFAULT_CAPACITY = 100;
    private E[] data;
    private int size;

    public UnsortedSet() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public UnsortedSet(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public static void main(String[] args) {
        UnsortedSet<Integer> bag = new UnsortedSet<Integer>();
        bag.add(2);
        bag.add(2);
        bag.add(1);
        System.out.println(Arrays.toString(bag.toArray()));
    }

    @Override
    public boolean add(E e) {
        // done implement unless collection shall be immutable
        checkNull(e);
        if (!contains(e)) {
            if(size== data.length){
                throw new IllegalStateException();
            }
            data[size++] = e;
            return true;
        }
        return false;
        //throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        // TODO implement unless collection shall be immutable
        checkNull(o);
        if(!contains(o)){
            return false;
        }
        int removeIndex = indexOf(o);
        data[removeIndex]=data[size-1];
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
        if (i == size){
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
