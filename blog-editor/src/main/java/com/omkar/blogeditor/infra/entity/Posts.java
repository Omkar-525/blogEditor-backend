package com.omkar.blogeditor.infra.entity;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Posts implements Serializable {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name ="content")
    private String content;

    @Column(name = "category")
    private String category;

    @ManyToMany
    @JoinTable(
            name ="users_posts",
            joinColumns =@JoinColumn(name = "id"),
            inverseJoinColumns =@JoinColumn(name="uid")
    )
    private Set<User> users;
}
