package com.group6.demo.service;

import com.group6.demo.entity.login.User;
import com.group6.demo.entity.login.UserDTO;
import com.group6.demo.repository.RoleRepository;
import com.group6.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new RuntimeException("user not found");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.annotationType().getName())).collect(Collectors.toList()));
    }

    @Override
    public void save(UserDTO userDTO) throws Exception {
        System.out.println("sever UserService save");

        User fetchedUser = this.userRepository.findByUsername(userDTO.getUsername());

        if (fetchedUser != null) {
            System.out.println("Duplicated :: " + fetchedUser.toString() );
            throw new Exception();
        }

        User user = new User();

        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
        user.setFirstName(userDTO.getFirstName());
        user.setEmail(userDTO.getEmail());

        Role role = this.roleRepository.findByName("ROLE_EMPLOYEE");
        user.setRoles(Arrays.asList(role));
        userDTO.setRoles(Arrays.asList(role.annotationType().getName()));


        this.userRepository.save(user);

        System.out.println(user.toString());
        userDTO.setId(user.getId());
    }

    @Override
    @Transactional
    public UserDTO findUserByUsername(String username) {
        User user = this.userRepository.findByUsername(username);

        if (user == null) {
            throw new RuntimeException("user not found");
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());

        userDTO.setEmail(user.getEmail());
        userDTO.setRoles(user.getRoles().stream().map(role-> role.annotationType().getName())
                .collect(Collectors.toList()));

        return userDTO;
    }
}
