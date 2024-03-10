package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenCorrectlyInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"3"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
    }

    @Test
    void whenMultipleCorrectlyInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"1", "test1", "2"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int start = input.askInt("Enter menu:");
        assertThat(start).isEqualTo(1);
        String str = input.askStr("Введите имя: ");
        assertThat(str).isEqualTo("test1");
        int finish = input.askInt("Enter menu:");
        assertThat(finish).isEqualTo(2);
    }

    @Test
    void whenNegativeInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int start = input.askInt("Enter menu:");
        assertThat(start).isEqualTo(-1);
    }
}