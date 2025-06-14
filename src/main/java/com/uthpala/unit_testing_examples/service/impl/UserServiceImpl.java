package com.uthpala.unit_testing_examples.service.impl;

import com.uthpala.unit_testing_examples.model.User;
import com.uthpala.unit_testing_examples.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUserById(Long userId) {
        // Example dummy implementation → would normally call a repository or API
        return new User(userId, "Example User", false);
    }
}
