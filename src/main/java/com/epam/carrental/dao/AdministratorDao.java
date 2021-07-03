package com.epam.carrental.dao;

import com.epam.carrental.domain.Administrator;

public interface AdministratorDao extends BaseDao<Administrator>{
    Administrator getByLogin(String login);
}
