package ru.job4j.ood.lsp.store;

import java.util.ArrayList;
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

    public void resort(List<Store> stores) {
        List<Food> allFood = stores.stream()
                .flatMap(store -> {
                    List<Food> foodList = new ArrayList<>(store.getList());
                    store.getList().clear();
                    foodList.forEach(store::setOriginalPrice);
                    return foodList.stream();
                })
                .toList();

        allFood.forEach(food -> sortFood(food, stores));
    }
}
