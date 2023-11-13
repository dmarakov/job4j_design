package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    public void checkFood() {
        Food food = new Food("Cheese", LocalDate.of(2023, 11, 1),
                LocalDate.of(2024, 11, 16), 100);
        Food food1 = new Food("Cake", LocalDate.of(2023, 11, 1),
                LocalDate.of(2023, 11, 16), 100);
        Food food2 = new Food("Butter", LocalDate.of(2023, 11, 1),
                LocalDate.of(2023, 11, 3), 100);
        ControlQuality cq = new ControlQuality();
        Store sh = new Shop();
        List<Store> list = List.of(sh);
        List<Food> expected = List.of(food1);
        cq.sortFood(food, list);
        cq.sortFood(food1, list);
        cq.sortFood(food2, list);
        assertThat(sh.getList()).hasSameElementsAs(expected);
    }
}