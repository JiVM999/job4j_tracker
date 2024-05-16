package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output output;

    public FindByNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать заявки по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Вывод заявок по имени ===");
        String searchName = input.askStr("Введите имя: ");
        List<Item> itemsByName = tracker.findByName(searchName);
        if (!itemsByName.isEmpty()) {
            for (Item i : itemsByName) {
                output.println(i);
            }
        } else {
            output.println("Заявки с именем: " + searchName + " не найдены.");
        }
        return true;
    }
}
