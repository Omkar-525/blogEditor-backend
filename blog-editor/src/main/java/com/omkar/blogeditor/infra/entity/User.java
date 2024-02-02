package com.omkar.blogeditor.infra.entity;

import jakarta.persistence.*;
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
    @Column(name = "U_Id")
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @ManyToMany(mappedBy = "users")
    private Set<Posts> myPost;

}
