package com.omkar.blogeditor.infra.entity;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
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

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;

    @Column(name = "date")
    private String date;
}
