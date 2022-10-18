package com.example.stack.mapper;

import com.example.stack.dto.UserDto;
import com.example.stack.entities.User;

public interface UserMapper {
    User toUser(UserDto userDto);

    UserDto fromUser(User user);
}

