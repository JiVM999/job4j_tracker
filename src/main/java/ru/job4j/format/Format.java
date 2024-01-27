package ru.job4j.format;

import java.util.Calendar;

public class Format {

    public static void getGreeting(String name) {
        System.out.format("Привет! Я %s%n", name);
    }

    public static void getGreetingAndTime(String name) {
        Calendar instance = Calendar.getInstance();
        System.out.format("Привет, %s! Текущая дата: %tF, Текущее время: %tT%n", name, instance, instance);
    }

    public static void main(String[] args) {
        getGreeting("Елена");
        getGreetingAndTime("Михаил");
        System.out.println(String.format("%1$,+016.2f", 5000000.0000));
    }

}