package com.manager.users.service.impl;

import com.manager.users.entity.UserModel;
import com.manager.users.entity.repository.UserRepository;
import com.manager.users.exceptions.UserNotFoundException;
import com.manager.users.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {

    @Resource
    private UserRepository userRepo;

    @Override
    public UserModel create(UserModel user) {
        return userRepo.save(user);
    }

    @Override
    public Iterable<UserModel> findAll() {
        return userRepo.findAll();
    }

    @Override
    public UserModel findById(Long id) throws UserNotFoundException {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(String.format("User with id [%s] doesn't exist.")));
    }

    @Override
    public UserModel update(UserModel user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public Long getUsersNumber() {
        return userRepo.count();
    }
}
