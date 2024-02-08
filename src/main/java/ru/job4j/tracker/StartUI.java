package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Выбрать: ");
            switch (select) {
                case 0:
                    StartUI.createItem(input, tracker);
                    break;
                case 1:
                    StartUI.findAllItems(tracker);
                    break;
                case 2:
                    StartUI.replaceItem(input, tracker);
                    break;
                case 3:
                    deleteItem(input, tracker);
                    break;
                case 4:
                    findItemById(input, tracker);
                    break;
                case 5:
                    findItemByName(input, tracker);
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    System.out.println("Некорректный ввод. Пожалуйста, выберите существующий пункт меню.");
            }
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Вывод заявок по имени ===");
        String searchName = input.askStr("Введите имя: ");
        Item[] itemsByName = tracker.findByName(searchName);
        if (itemsByName.length > 0) {
            for (Item i : itemsByName) {
                System.out.println(i);
            }
        } else {
            System.out.println("Заявки с именем: " + searchName + " не найдены.");
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
    }

    public static void findAllItems(Tracker tracker) {
        System.out.println("=== Вывод всех заявок ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item i : items) {
                System.out.println(i);
            }
        } else {
            System.out.println("Хранилище еще не содержит заявок");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Редактирование заявки ===");
        int id = input.askInt("Введите id: ");
        String newName = input.askStr("Введите имя: ");
        Item newItem = new Item(newName);
        if (tracker.replace(id, newItem)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
    }

    private static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Удаление заявки ===");
        int deleteId = input.askInt("Введите id: ");
        Item deletedItem = tracker.findById(deleteId);
        tracker.delete(deleteId);
        System.out.println(deletedItem != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
    }

    private static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Вывод заявки по id ===");
        int searchId = input.askInt("Введите id: ");
        Item foundItem = tracker.findById(searchId);
        if (foundItem != null) {
            System.out.println(foundItem);
        } else {
            System.out.println("Заявка с введенным id: " + searchId + " не найдена.");
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}