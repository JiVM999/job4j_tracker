package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

public class FindByIdAction implements UserAction {
    private final Output output;

    public FindByIdAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать заявку по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Вывод заявки по id ===");
        int searchId = input.askInt("Введите id: ");
        Item foundItem = tracker.findById(searchId);
        if (foundItem != null) {
            output.println(foundItem);
        } else {
            output.println("Заявка с введенным id: " + searchId + " не найдена.");
        }
        return true;
    }
}
