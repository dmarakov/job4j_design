package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Disabled
class GeneratorTest {

    @Test
    public void whenKeyExistsInMap() {
        Generator generator = new TextGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        String expected = "I am a Dmitriy, Who are you?";
        Map<String, String> map = Map.of("Dmitriy", "you");
        assertThat(expected).isEqualTo(generator.produce(template, map));
    }

    @Test
    public void whenKeyDoesNotExistsInMap() {
        Generator generator = new TextGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        String expected = "I am a Dmitriy, Who are you?";
        Map<String, String> map = Map.of("Sasha", "me");
        assertThat(expected).isNotEqualTo(generator.produce(template, map));
    }

    @Test
    public void whenMapDoesNotHaveKey() {
        Generator generator = new TextGenerator();
        String template = "I am a ${name} ${surname}, Who are ${subject}?";
        Map<String, String> map = Map.of("Dmitriy", "me");
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenMapHasExtraKeys() {
        Generator generator = new TextGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of("Dmitriy", "me", "Sasha", "you");
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class);
    }


}