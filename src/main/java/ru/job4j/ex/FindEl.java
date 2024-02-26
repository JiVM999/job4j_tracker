package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] array = {"Mexico", "USA", "Russia", "Poland"};
        try {
            System.out.println(indexOf(array, "USA"));
            System.out.println(indexOf(array, "Italy"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}