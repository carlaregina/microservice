package com.ms.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.user.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}