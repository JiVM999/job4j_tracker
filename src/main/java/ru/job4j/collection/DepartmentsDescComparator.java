package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int min = Math.min(left.length(), right.length());
        boolean asc = (left.substring(0, min - 2)
                .equals(right.substring(0, min - 2)))
                && min != 2;
        if (asc) {
            return new StringCompare().compare(left, right);
        }
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return Character.compare(right.charAt(i), left.charAt(i));
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}