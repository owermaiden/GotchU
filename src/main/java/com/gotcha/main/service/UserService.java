package com.gotcha.main.service;

import com.gotcha.main.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getAll();
}
