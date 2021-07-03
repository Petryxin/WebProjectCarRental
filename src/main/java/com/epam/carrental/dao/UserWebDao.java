package com.epam.carrental.dao;

import com.epam.carrental.domain.UserWeb;


public interface UserWebDao extends BaseDao<UserWeb> {
    UserWeb getByLogin(String login);
}
