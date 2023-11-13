package ru.job4j.ood.lsp.store;

import java.util.ArrayList;
import java.util.List;

public class Trash extends AbstractStore {

    private final List<Food> trashList = new ArrayList<>();

    @Override
    public boolean check(Food food) {
        boolean rsl = false;
        if (calculateExpiredPercent(food) >= 100) {
            trashList.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getList() {
        return trashList;
    }
}
