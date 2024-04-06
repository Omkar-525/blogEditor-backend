package com.omkar.blogeditor.infra.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="title")
    private String title;

    @Column(name ="content")
    @Lob
    private String content;

    @Column(name = "category")
    private String category;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    @JsonIgnore
    private User user;

    @Column(name = "date")
    private String date;
}
