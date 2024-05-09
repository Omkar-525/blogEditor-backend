package com.omkar.blogeditor.infra.repository;

import com.omkar.blogeditor.infra.entity.Posts;
import com.omkar.blogeditor.infra.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Posts,Long> {
    List<Posts> findAllByUser(User user);

    Optional<Posts> findByIdAndUser(Long id, User user);
}
