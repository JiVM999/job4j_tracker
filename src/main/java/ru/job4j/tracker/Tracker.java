package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public void delete(int id) {
        int idx = indexOf(id);
        boolean condition = idx != -1;
        if (condition) {
            items.remove(idx);
            items.add(size - 1, null);
            size--;
        }
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public boolean replace(int id, Item item) {
        int idx = indexOf(id);
        boolean result = idx != -1;
        if (result) {
            item.setId(id);
            items.set(idx, item);
        }
        return result;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        int idx = 0;
        for (int index = 0; index < size; index++) {
            Item item = items.get(index);
            if (key.equals(item.getName())) {
                rsl.add(idx, item);
                idx++;
            }
        }
        return rsl;
    }
}