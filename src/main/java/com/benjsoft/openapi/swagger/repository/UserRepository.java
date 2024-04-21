package com.benjsoft.openapi.swagger.repository;

import com.benjsoft.openapi.swagger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
