package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

public class DeleteAction implements UserAction {
    private final Output output;

    public DeleteAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Удаление заявки ===");
        int deleteId = input.askInt("Введите id: ");
        Item deletedItem = tracker.findById(deleteId);
        tracker.delete(deleteId);
        output.println(deletedItem != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
        return true;
    }
}
