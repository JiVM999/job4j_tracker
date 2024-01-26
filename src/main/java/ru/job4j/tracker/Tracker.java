package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public void delete(int id) {
        int idx = indexOf(id);
        if (idx != -1) {
            System.arraycopy(items, idx + 1, items, idx, size - idx - 1);
            items[size - 1] = null;
            size--;
        }
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public boolean replace(int id, Item item) {
        int idx = indexOf(id);
        if (idx == -1) {
            return false;
        }
        item.setId(id);
        items[idx] = item;
        return true;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.length];
        int idx = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (key.equals(item.getName())) {
                rsl[idx] = item;
                idx++;
            }
        }
        rsl = Arrays.copyOf(rsl, idx);
        return rsl;
    }
}