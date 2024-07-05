package ru.job4j.tracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ItemSortTest {

    @Test
    void whenAscSort() {
        List<Item> items = Arrays.asList(
                new Item("5 item", 154),
                new Item("1 item", 1234),
                new Item("3 item", 11235),
                new Item("2 item", 1636),
                new Item("4 item", 125)
        );
        List<Item> expected = Arrays.asList(
                new Item("1 item", 1234),
                new Item("2 item", 1636),
                new Item("3 item", 11235),
                new Item("4 item", 125),
                new Item("5 item", 154)
        );
        items.sort(new ItemAscByName());
        Assertions.assertArrayEquals(items.toArray(), expected.toArray());
    }

    @Test
    void whenDescSort() {
        List<Item> items = Arrays.asList(
                new Item("5 item", 154),
                new Item("1 item", 1234),
                new Item("3 item", 11235),
                new Item("2 item", 1636),
                new Item("4 item", 125)
        );
        List<Item> expected = Arrays.asList(
                new Item("5 item", 154),
                new Item("4 item", 125),
                new Item("3 item", 11235),
                new Item("2 item", 1636),
                new Item("1 item", 1234)
        );
        items.sort(new ItemDescByName());
        Assertions.assertArrayEquals(items.toArray(), expected.toArray());
    }
}