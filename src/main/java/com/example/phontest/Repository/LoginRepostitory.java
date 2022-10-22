package com.example.phontest.Repository;

import com.example.phontest.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepostitory extends JpaRepository<Login, Long> {
    Login  findByUsernameAndPassword(String username, String password);
}
