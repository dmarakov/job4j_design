package ru.job4j.ood.lsp.parking;

public class AbstractCar implements Car {

    private int size;
    private int slotNumber;

    public AbstractCar(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}
