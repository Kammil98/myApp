package com.manager.users.service;

import com.manager.users.entity.UserModel;
import com.manager.users.exceptions.UserNotFoundException;

public interface UserService {
    UserModel create(UserModel user);

    Iterable<UserModel> findAll();

    UserModel findById(Long id) throws UserNotFoundException;

    UserModel update(UserModel user);

    void deleteById(Long id);

    Long getUsersNumber();
}
