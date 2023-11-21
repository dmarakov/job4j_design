package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void checkPassengerCar() {
        Parking parking = new Parking();
        Car car = new PassengerCar();
        Car car1 = new PassengerCar();
        CarChecking cc = new CarChecking();
        List<Car> carList = List.of(car, car1);
        List<Car> expected = List.of(car, car1);
        cc.check(carList);
        assertThat(parking.getList()).hasSameElementsAs(expected);
    }

    @Test
    public void checkTruck() {
        Parking parking = new Parking();
        Car car = new PassengerCar();
        Car car1 = new PassengerCar();
        CarChecking cc = new CarChecking();
        List<Car> carList = List.of(car, car1);
        List<Car> expected = List.of(car, car1);
        cc.check(carList);
        assertThat(parking.getList()).hasSameElementsAs(expected);
    }
}