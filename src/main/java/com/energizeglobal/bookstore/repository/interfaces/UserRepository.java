package com.energizeglobal.bookstore.repository.interfaces;


import com.energizeglobal.bookstore.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByActivationCode(String code);
}
