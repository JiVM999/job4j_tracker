package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftArray = left.split("/");
        String[] rightArray = right.split("/");
        int min = Math.min(leftArray.length, rightArray.length);
        int firstEl = Integer.compare(rightArray[0].charAt(1), leftArray[0].charAt(1));
        if (firstEl != 0) {
            return firstEl;
        }
        for (int i = 0; i < min; i++) {
            for (int j = 0; j < leftArray[i].length(); j++) {
                int comp = Character.compare(leftArray[i].charAt(j), rightArray[i].charAt(j));
                if (comp != 0) {
                    return comp;
                }
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}