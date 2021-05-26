package com.group6.demo.entity.login;

import lombok.*;
import org.springframework.context.annotation.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;
    @Column
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column
    private String email;

    @Embedded
    private Address address;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}
