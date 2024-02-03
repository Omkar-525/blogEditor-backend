package com.omkar.blogeditor.infra.repository;

import com.omkar.blogeditor.infra.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts,Long> {
}
