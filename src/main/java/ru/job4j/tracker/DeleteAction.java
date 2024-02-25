package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Удаление заявки ===");
        int deleteId = input.askInt("Введите id: ");
        Item deletedItem = tracker.findById(deleteId);
        tracker.delete(deleteId);
        System.out.println(deletedItem != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
        return true;
    }
}
