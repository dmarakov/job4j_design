package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements LinkedList<E> {

    private int size = 0;
    private int modCount = 0;
    private Node<E> head;
    private Node<E> tail;

    @Override
    public void add(E value) {
        Node<E> l = tail;
        Node<E> newNode = new Node<>(value, null, l);
        tail = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> rsl;
        if ((size / 2) > index) {
            rsl = head;
            for (int i = 0; i < index; i++) {
                rsl = rsl.next;
            }
        } else {
            rsl = tail;
            for (int i = size - 1; i > index; i--) {
                rsl = rsl.prev;
            }
        }
        return rsl.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> point = head;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = point.item;
                point = point.next;
                return element;
            }
        };
    }

    private static class Node<E> {
        private final E item;
        private Node<E> next;
        private final Node<E> prev;

        Node(E element, Node<E> next, Node<E> prev) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}