package com.epam.carrental.dao;


import java.util.List;

public interface BaseDao <T> {
    void create(T t);
    void delete(Integer id);
    void update (T t);
    List<T> getAll();
}
