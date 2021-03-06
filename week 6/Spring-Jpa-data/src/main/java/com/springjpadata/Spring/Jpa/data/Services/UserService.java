package com.springjpadata.Spring.Jpa.data.Services;

import com.springjpadata.Spring.Jpa.data.model.User;
import com.springjpadata.Spring.Jpa.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> list() {
        return userRepository.findAll();
    }
}