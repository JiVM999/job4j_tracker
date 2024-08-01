package ru.job4j.lambda;

import ru.job4j.collection.StringCompare;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] attachments = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> Integer.compare(left.getSize(), right.getSize());
        Comparator<String> stringComparator = new StringCompare();
        Comparator<String> comparatorText = (left, right) -> stringComparator.compare(left, right);
        Comparator<String> comparatorDescSize = (left, right) -> stringComparator.compare(right, left);
        Arrays.sort(attachments, comparator);
    }

}