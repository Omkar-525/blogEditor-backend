package com.omkar.blogeditor.infra.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Profile implements Serializable {

    @Id
    @Column(name = "pid")
    private long id;

    @Column(name = "user")
    private Set<User> user;

    @Column(name ="posts")
    private Set<Posts> posts;


}
