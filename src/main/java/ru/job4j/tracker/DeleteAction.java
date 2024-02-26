package ru.job4j.tracker;

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
