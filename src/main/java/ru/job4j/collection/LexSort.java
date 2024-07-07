package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftArr = left.split(" ")[0].split("\\.");
        String[] rightArr = right.split(" ")[0].split("\\.");
        return Integer.compare(Integer.parseInt(leftArr[0]), Integer.parseInt(rightArr[0]));
    }
}