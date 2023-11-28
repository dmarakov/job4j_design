package ru.job4j.ood.isp.menu;

public class MenuPrinterResolver implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo mii : menu) {
            if (mii.getNumber().length() == 2) {
                System.out.println(mii.getName() + " " + mii.getNumber());
            } else {
                System.out.println("-".repeat((int) Math.pow(mii.getNumber()
                        .chars()
                        .filter(Character::isDigit)
                        .count(), 2)) + " " + mii.getName() + " " + mii.getNumber());
            }
        }
    }
}
