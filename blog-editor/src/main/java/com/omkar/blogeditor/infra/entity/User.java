package com.omkar.blogeditor.infra.entity;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    @Id
    @Column(name = "uid")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "active")
    private boolean active;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<Posts> posts;

}
