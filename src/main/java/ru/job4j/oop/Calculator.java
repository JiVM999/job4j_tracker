package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return x - b;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int f) {
        return multiply(f) + sum(f) + minus(f) + divide(f);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int num = 5;
        int mult = calculator.multiply(num);
        System.out.println(mult);
        int sum = calculator.sum(num);
        System.out.println(sum);
        int div = calculator.divide(num);
        System.out.println(div);
        int min = calculator.minus(num);
        System.out.println(min);
        int sums = calculator.sumAllOperation(num);
        System.out.println(sums);
    }
}