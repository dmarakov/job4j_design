package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    public void checkPassengerCar() {
        AbstractParking parking = new MixedParking(4, 4);
        AbstractCar car = new PassengerCar(1);
        AbstractCar car1 = new PassengerCar(1);
        parking.add(car);
        parking.add(car1);
        List<Car> expected = List.of(car, car1);
        assertThat(parking.getPassangerCarList()).hasSameElementsAs(expected);
    }

    @Test
    public void checkTruck() {
        MixedParking parking = new MixedParking(4, 4);
        AbstractCar car = new Truck(2);
        AbstractCar car1 = new Truck(3);
        parking.add(car);
        parking.add(car1);
        List<Car> expected = List.of(car);
        List<Car> expected1 = List.of(car1);
        assertThat(parking.getTruckList()).hasSameElementsAs(expected);
        assertThat(parking.getPassangerCarList()).hasSameElementsAs(expected1);
    }
}