package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Едем");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("В автобусе " + passengers + " пассажиров");
    }

    @Override
    public int fillUp(int fuel) {
        return fuel * 65;
    }
}
