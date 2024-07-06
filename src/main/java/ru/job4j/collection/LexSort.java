package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftArr = left.split(" ")[0].split("\\.");
        String[] rightArr = right.split(" ")[0].split("\\.");
        for (int i = 0; i < Math.min(leftArr.length, rightArr.length); i++) {
            int comp = Integer.compare(Integer.parseInt(leftArr[i]), Integer.parseInt(rightArr[i]));
            if (comp != 0) {
                return comp;
            }
        }
        return 0;
    }
}