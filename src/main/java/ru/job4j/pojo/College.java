package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Михаил Зенков Дмитриевич");
        student.setGroup("ИС-1");
        student.setDate(LocalDate.parse("2022-09-01"));
        System.out.println("Студент " + student.getFio() + " из группы " + student.getGroup() + " поступил " + student.getDate());
    }
}
