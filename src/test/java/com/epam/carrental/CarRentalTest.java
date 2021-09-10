package com.epam.carrental;


import com.epam.carrental.model.Car;
import com.epam.carrental.model.Orders;
import com.epam.carrental.services.CarService;
import com.epam.carrental.services.OrdersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CarRentalTest {

    @Test
    public void getSelectedCar(){
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car();
        car1.setId(1);
        Car car2 = new Car();
        car2.setId(2);
        Car car3 = new Car();
        car3.setId(3);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        Integer carId = 2;

        CarService carService = new CarService();
        Car selectedCar = carService.getSelectedCar(carId, cars);

        Assertions.assertEquals(car2,selectedCar);
    }

    @Test
    public void getAmount(){
        OrdersService ordersService = new OrdersService();
        int amount = ordersService.getAmount(2, 14);

        Assertions.assertEquals(28,amount);
    }

    @Test
    public void getOrderById(){
        List<Orders> ordersList = new ArrayList<>();
        Orders orders1 = new Orders();
        orders1.setId(1);
        Orders orders2 = new Orders();
        orders2.setId(2);
        Orders orders3 = new Orders();
        orders3.setId(3);
        ordersList.add(orders1);
        ordersList.add(orders2);
        ordersList.add(orders3);

        Integer carId = 3;

        OrdersService ordersService = new OrdersService();
        Orders orderById = ordersService.getOrderById(carId, ordersList);

        Assertions.assertEquals(orders3,orderById);
    }
}
