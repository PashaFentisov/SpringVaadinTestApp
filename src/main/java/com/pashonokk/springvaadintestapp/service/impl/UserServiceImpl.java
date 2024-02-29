package com.pashonokk.springvaadintestapp.service.impl;

import com.pashonokk.springvaadintestapp.dto.UserSavingDto;
import com.pashonokk.springvaadintestapp.entity.User;
import com.pashonokk.springvaadintestapp.repository.UserRepository;
import com.pashonokk.springvaadintestapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(UserSavingDto userSavingDto) {
        User user = new User();
        user.setName(userSavingDto.getName());
        user.setEmail(userSavingDto.getEmail());
        user.setPassword(userSavingDto.getPassword());
        return userRepository.save(user);
    }
}
