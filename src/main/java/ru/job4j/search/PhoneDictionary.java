package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combinePhone = person -> person.getPhone().contains(key);
        Predicate<Person> combineName = person -> person.getName().contains(key);
        Predicate<Person> combineAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combineSurname = person -> person.getSurname().contains(key);

        Predicate<Person> combineAll = combinePhone.or(combineName)
                .or(combineAddress)
                .or(combineSurname);

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combineAll.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
