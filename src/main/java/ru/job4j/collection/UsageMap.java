package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> accounts = new HashMap<>();
        accounts.put("qwerty@mail.com", "Mikhail Zenkov");
        accounts.put("asd@gmail.com", "Andrey Lenkov");
        accounts.put("petr@gmail.com", "Mikhail Arsentev");
        accounts.put("petr@gmail.com", "Petr Arsentev");
        for (Map.Entry<String, String> entry : accounts.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}
