package com.epam.carrental.dao;

import com.epam.carrental.model.Administrator;

public interface AdministratorDao extends BaseDao<Administrator>{
    Administrator getByLogin(String login);
}
