package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Показать заявки по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}
