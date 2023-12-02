package ru.job4j.ood.lsp.store;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class AbstractStore implements Store {

    public static double calculateExpiredPercent(Food food) {
        LocalDate now = LocalDate.of(2023, 11, 13);
        double expiryDate = Math.abs(ChronoUnit.DAYS.between(food.getExpiryDate(), food.getCreateDate()));
        double daysLeft = ChronoUnit.DAYS.between(now, food.getExpiryDate());
        return 100 - (int) ((daysLeft * 100) / expiryDate);
    }

    public boolean setOriginalPrice(Food food) {
        boolean rsl = false;
        if (food.getDiscount() != 0) {
            food.setPrice(food.getPrice() + (food.getPrice() * food.getDiscount()));
            rsl = true;
        }
        return rsl;
    }

    public static void main(String[] args) {
        Food food = new Food("Cake", LocalDate.of(2023, 11, 1),
                LocalDate.of(2023, 11, 2), 100);
        System.out.println(calculateExpiredPercent(food));
    }
}
