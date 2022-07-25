package bai3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    private void ensureCapacity() {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            System.out.println("Index invalid");
            return;
        }
        if (size == elements.length) {
            ensureCapacity();
        }
        for (int i=size;i>index;i--){
            elements[i]=elements[i-1];
        }
        elements[index]=element;
        size+=1;
    }

    public E remove(int index) {
        E elementDele = null;
        elementDele = (E) elements[index];
        for (int i = index; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return elementDele;
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public int size() {
        return this.size;
    }

    public boolean contains(E o) {
        for (int i = 0; i < elements.length; i++) {
            if (o.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < elements.length; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }


}
