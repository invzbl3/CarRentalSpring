package com.project.carrental.entity;

import lombok.*;
import javax.persistence.*;

@Data
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable=false, nullable=false)
    private Integer userID;

    @Column(name = "usertype_id", nullable=false)
    private Integer userTypeID;

    @Column(name = "login", length=50, nullable=false)
    private String login;

    @Column(name = "password", length=50, nullable=false)
    private String password;
}
