package ru.job4j.ood.lsp.store;

import java.util.List;

public interface Store {
    public boolean check(Food food);

    public List<Food> getList();
    public boolean setOriginalPrice(Food food);
}
