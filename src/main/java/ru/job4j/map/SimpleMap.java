package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean rsl;
        int index = indexFor(hash(keyHashCode(key)));
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            rsl = true;
            if (count >= capacity * LOAD_FACTOR) {
                expand();
            }
        } else {
            rsl = false;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private int keyHashCode(K key) {
        return key == null ? 0 : key.hashCode();
    }

    private void expand() {
        MapEntry<K, V>[] newTable = table;
        capacity = capacity * 2;
        table = new MapEntry[capacity];
        count = 0;
        for (MapEntry<K, V> tempValue : newTable) {
            if (tempValue != null) {
                table[indexFor(hash(keyHashCode(tempValue.key)))] = new MapEntry<>(tempValue.key, tempValue.value);
            }
        }
    }

    @Override
    public V get(K key) {
        int index = indexFor(hash(keyHashCode(key)));
        V rsl = null;
        if (checkKeysEquals(key)) {
            rsl = table[index].value;
        }
        return rsl;
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(keyHashCode(key)));
        boolean rsl;
        if (checkKeysEquals(key)) {
            table[index] = null;
            rsl = true;
            count--;
            modCount++;
        } else {
            rsl = false;
        }
        return rsl;
    }

    public boolean checkKeysEquals(K key) {
        int index = indexFor(hash(keyHashCode(key)));
        return table[index] != null && keyHashCode(table[index].key) == keyHashCode(key)
                && Objects.equals(key, table[index].key);
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            int point = 0;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (point < table.length && table[point] == null) {
                    point++;
                }
                return point < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[point++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}