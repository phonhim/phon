package com.example.phontest.Service.impl;

import com.example.phontest.Entity.Login;
import com.example.phontest.Repository.LoginRepostitory;
import com.example.phontest.Service.Logiservice;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements Logiservice {
    private final LoginRepostitory loginRepostitory;

    public LoginServiceImpl(LoginRepostitory loginRepostitory) {
        this.loginRepostitory = loginRepostitory;
    }

    @Override
    public Login saveRegisterLogin(Login login) {
        return loginRepostitory.save(login);
    }
    @Override
    public Login login(String username, String password) {
        Login user =loginRepostitory.findByUsernameAndPassword(username, password);
        return user;
    }

}
