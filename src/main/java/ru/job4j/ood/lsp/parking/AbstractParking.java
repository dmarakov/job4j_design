package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class AbstractParking implements Parking {

    private List<Car> passengerCar = new ArrayList<>();
    private List<Car> truck = new ArrayList<>();
    private final int maxEmptyPassengerCar;
    private int busyPassengerCarSlots;
    private final int maxEmptyTruck;
    private int busyTruckSlots;

    public AbstractParking(int maxEmptyPassengerCar, int maxEmptyTruck) {
        this.maxEmptyPassengerCar = maxEmptyPassengerCar;
        this.busyPassengerCarSlots = 0;
        this.maxEmptyTruck = maxEmptyTruck;
        this.busyTruckSlots = 0;
    }

    @Override
    public void add(AbstractCar car) {
        if (car.getSize() == 1 && busyPassengerCarSlots < maxEmptyPassengerCar) {
            passengerCar.add(car);
            busyPassengerCarSlots++;
        }
        if (car.getSize() > 1 && busyTruckSlots + car.getSize() < maxEmptyTruck) {
            truck.add(car);
            busyTruckSlots = busyTruckSlots + car.getSize();
        } else if (car.getSize() > 1 && busyTruckSlots + car.getSize() > maxEmptyTruck) {
            passengerCar.add(car);
            busyPassengerCarSlots = busyPassengerCarSlots + car.getSize();
        }

    }

    public List<Car> getPassangerCarList() {
        return passengerCar;
    }

    public List<Car> getTruckList() {
        return truck;
    }

}
