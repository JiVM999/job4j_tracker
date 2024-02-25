package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Показать заявку по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Вывод заявки по id ===");
        int searchId = input.askInt("Введите id: ");
        Item foundItem = tracker.findById(searchId);
        if (foundItem != null) {
            System.out.println(foundItem);
        } else {
            System.out.println("Заявка с введенным id: " + searchId + " не найдена.");
        }
        return true;
    }
}
