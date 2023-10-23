package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        String str = switch (position) {
            case 1 -> "Пусть бегут неуклюже";
            case 2 -> "Спокойной ночи";
            default -> "Песня не найдена";
        };
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        jukebox.music(1);
        jukebox.music(2);
        jukebox.music(50);
        jukebox.music(0);
    }
}
