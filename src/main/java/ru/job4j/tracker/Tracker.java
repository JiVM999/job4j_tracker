package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
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
        }
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
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
        for (Item item : items) {
            if (key.equals(item.getName())) {
                rsl.add(idx, item);
                idx++;
            }
        }
        return rsl;
    }
}