package com.group6.demo.service;

import com.group6.demo.entity.login.User;
import com.group6.demo.entity.login.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    void save(UserDTO userDTO) throws Exception;

    @Transactional
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    UserDTO findUserByUsername(String username);
}
