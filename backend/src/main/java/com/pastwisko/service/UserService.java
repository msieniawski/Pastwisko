package com.pastwisko.service;

import com.pastwisko.model.User;

public interface UserService extends CRUDService<User> {

    User findByUserName(String userName);

}
