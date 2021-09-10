package com.epam.carrental.dao;


import com.epam.carrental.model.Car;

public interface CarDao extends BaseDao<Car> {
    Car getById(Integer carId);
}
