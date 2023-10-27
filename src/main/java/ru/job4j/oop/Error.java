package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active ? "Ошибка" : "Ошибки нет");
        System.out.println("№" + status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error systemError = new Error(true, 36555, "Out of memory\n");
        Error programError = new Error(true, 79543, "Fatal error\n");
        systemError.printInfo();
        programError.printInfo();
    }
}
