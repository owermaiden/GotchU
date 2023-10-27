package com.gotcha.main.service.impl;

import com.gotcha.main.entity.User;
import com.gotcha.main.repository.UserRepository;
import com.gotcha.main.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User save(User user) {
        System.out.println(user.getFirstName());
        return repository.save(user);
    }

    @Override
    @Cacheable(value = "users")
    public List<User> getAll() {
        System.out.println("called");
        return repository.findAll();
    }
}
