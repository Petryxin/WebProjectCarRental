package com.epam.carrental.services;

import com.epam.carrental.model.Car;

import java.util.List;

public class CarService {
    public Car getSelectedCar(Integer carId, List<Car> cars) {
        return cars.stream().filter(u -> u.getId().equals(carId)).findAny().orElse(null);
    }
}
