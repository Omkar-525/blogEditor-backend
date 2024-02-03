package com.omkar.blogeditor.infra.repository;

import com.omkar.blogeditor.infra.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
}
