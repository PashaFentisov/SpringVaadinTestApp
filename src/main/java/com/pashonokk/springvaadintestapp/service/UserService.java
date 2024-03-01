package com.pashonokk.springvaadintestapp.service;

import com.pashonokk.springvaadintestapp.dto.UserSavingDto;
import com.pashonokk.springvaadintestapp.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User saveUser(UserSavingDto userSavingDto);

    User getUserById(Long id);
}
