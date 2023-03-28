package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {

    private int size = 0;
    private int modCount = 0;
    private Node<T> head;

    public void add(T value) {
        Node<T> f = head;
        if (f == null) {
            head = new Node<>(value, null);
        } else {
            while (f.next != null) {
                f = f.next;
            }
            f.next = new Node<>(value, null);
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> rsl = head;
        for (int i = 0; i < index; i++) {
            rsl = rsl.next;
        }
        return rsl.item;
    }


    public T deleteFirst() {
        if (size <= 0) {
            throw new NoSuchElementException();
        }
        T rsl = head.item;
        Node<T> tmp = head.next;
        head.next = null;
        head.item = null;
        head = tmp;
        size--;
        modCount++;
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> point = head;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T element = point.item;
                point = point.next;
                return element;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}