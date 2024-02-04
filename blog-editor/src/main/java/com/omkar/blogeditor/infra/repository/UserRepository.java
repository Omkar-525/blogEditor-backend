package com.omkar.blogeditor.infra.repository;

import com.omkar.blogeditor.infra.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
