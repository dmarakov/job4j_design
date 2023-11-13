package ru.job4j.ood.lsp.store;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore {

    private final List<Food> shopList = new ArrayList<>();

    @Override
    public boolean check(Food food) {
        boolean rsl = false;
        if (calculateExpiredPercent(food) > 75) {
            food.setDiscount(0.20);
            food.setPrice(food.getPrice() - (food.getPrice() * food.getDiscount()));
        }
        if ((calculateExpiredPercent(food) > 25) && (calculateExpiredPercent(food) < 100)) {
            shopList.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getList() {
        return shopList;
    }
}
