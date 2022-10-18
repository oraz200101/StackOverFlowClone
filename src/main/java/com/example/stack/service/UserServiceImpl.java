package com.example.stack.service;

import com.example.stack.dao.UserRepository;
import com.example.stack.dto.UserDto;
import com.example.stack.entities.User;
import com.example.stack.mapper.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapperImpl userMapper;

    @Autowired(required = false)
    public UserServiceImpl(UserRepository userRepository, UserMapperImpl userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public User save(UserDto userDto) {
        if (!Objects.equals(userDto.getPassword(), userDto.getMatchingPassword())) {
            throw new RuntimeException("password no equal");
        }
        User user = userMapper.toUser(userDto);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(UserDto userDto) {
        return null;
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByName(username);
        if (user == null) {
            throw new RuntimeException("user not found");
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole().name()));
        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                roles
        );
    }
}
