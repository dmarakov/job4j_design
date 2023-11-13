package ru.job4j.ood.lsp.store;

import java.util.List;

public class ControlQuality {
    private List<Store> store;

    public void sortFood(Food food, List<Store> store) {
        for (Store store1 : store) {
            if (store1.check(food)) {
                break;
            }
        }
    }
}
