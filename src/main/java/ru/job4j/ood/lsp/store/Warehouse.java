package ru.job4j.ood.lsp.store;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends AbstractStore {
    private final List<Food> warehousList = new ArrayList<>();

    @Override
    public boolean check(Food food) {
        boolean rsl = false;
        if (calculateExpiredPercent(food) < 25) {
            warehousList.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getList() {
        return warehousList;
    }
}
