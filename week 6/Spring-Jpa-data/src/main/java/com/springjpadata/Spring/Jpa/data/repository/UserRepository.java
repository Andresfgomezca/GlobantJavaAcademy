package com.springjpadata.Spring.Jpa.data.repository;

import com.springjpadata.Spring.Jpa.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository {

}
