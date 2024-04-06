package com.omkar.blogeditor.infra.model;

import com.omkar.blogeditor.infra.entity.Posts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO implements Serializable {

    public Long id;
    public String date;
    public String title;
    public String content;
    public String category;

    public PostDTO(Posts posts){
        this.id = posts.getId();
        this.date = posts.getDate();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.category = posts.getCategory();
    }
}
