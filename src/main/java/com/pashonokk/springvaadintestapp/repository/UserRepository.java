package com.pashonokk.springvaadintestapp.repository;

import com.pashonokk.springvaadintestapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
