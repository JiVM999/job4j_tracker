package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Выбрать: ");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0:
                    System.out.println("=== Создание новой заявки ===");
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    Item item = new Item(name);
                    tracker.add(item);
                    System.out.println("Добавленная заявка: " + item);
                    break;
                case 1:
                    System.out.println("=== Вывод всех заявок ===");
                    Item[] items = tracker.findAll();
                    if (items.length > 0) {
                        for (Item i : items) {
                            System.out.println(i);
                        }
                    } else {
                        System.out.println("Хранилище еще не содержит заявок");
                    }
                    break;
                case 2:
                    System.out.println("=== Редактирование заявки ===");
                    System.out.print("Введите id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите имя: ");
                    String newName = scanner.nextLine();
                    Item newItem = new Item(newName);
                    if (tracker.replace(id, newItem)) {
                        System.out.println("Заявка изменена успешно.");
                    } else {
                        System.out.println("Ошибка замены заявки.");
                    }
                    break;
                case 3:
                    System.out.println("=== Удаление заявки ===");
                    System.out.print("Введите id: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    Item deletedItem = tracker.findById(deleteId);
                    tracker.delete(deleteId);
                    System.out.println(deletedItem != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
                    break;
                case 4:
                    System.out.println("=== Вывод заявки по id ===");
                    System.out.print("Введите id: ");
                    int searchId = Integer.parseInt(scanner.nextLine());
                    Item foundItem = tracker.findById(searchId);
                    if (foundItem != null) {
                        System.out.println(foundItem);
                    } else {
                        System.out.println("Заявка с введенным id: " + searchId + " не найдена.");
                    }
                    break;
                case 5:
                    System.out.println("=== Вывод заявок по имени ===");
                    System.out.print("Введите имя: ");
                    String searchName = scanner.nextLine();
                    Item[] itemsByName = tracker.findByName(searchName);
                    if (itemsByName.length > 0) {
                        for (Item i : itemsByName) {
                            System.out.println(i);
                        }
                    } else {
                        System.out.println("Заявки с именем: " + searchName + " не найдены.");
                    }
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    System.out.println("Некорректный ввод. Пожалуйста, выберите существующий пункт меню.");
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Добавить новую заявку", "Показать все заявки", "Изменить заявку",
                "Удалить заявку", "Показать заявку по id", "Показать заявки по имени",
                "Завершить программу"
        };
        System.out.println("Меню:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}