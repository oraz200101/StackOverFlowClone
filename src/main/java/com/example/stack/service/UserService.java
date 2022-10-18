package com.example.stack.service;

import com.example.stack.dto.UserDto;
import com.example.stack.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserDto userDto);

    User update(UserDto userDto);

    User findByName(String login);
}
