package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCodeBook = new Book("Clean code", 150);
        Book dataStructuresBook = new Book("Data structures", 600);
        Book programmingForKidsBook = new Book("Programming for kids", 300);
        Book androidDevelopmentBook = new Book("Android development", 900);
        Book[] books = new Book[4];
        books[0] = cleanCodeBook;
        books[1] = dataStructuresBook;
        books[2] = programmingForKidsBook;
        books[3] = androidDevelopmentBook;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - Количество страниц: " + book.getNumberOfPages());
        }
        System.out.println("\nПерестановка 0 и 3 индексов");
        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - Количество страниц: " + book.getNumberOfPages());
        }
        System.out.println("\nВывод книг с названием Clean code");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - Количество страниц: " + book.getNumberOfPages());
            }
        }
    }
}
