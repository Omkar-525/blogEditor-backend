package com.omkar.blogeditor.infra.entity;

import jakarta.persistence.*;
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
    @Column(name = "Id")
    private long id;

    @Column(name ="Content")
    private String content;

    @Column(name = "Category")
    private String category;

    @ManyToMany
    @JoinTable(
            name ="Users_Posts",
            joinColumns =@JoinColumn(name = "id"),
            inverseJoinColumns =@JoinColumn(name="U_Id")
    )
    private Set<User> users;
}
