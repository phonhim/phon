package com.example.phontest.Service;



import com.example.phontest.Entity.Login;
import com.example.phontest.Repository.LoginRepostitory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface Logiservice {

    Login login (String username, String password);
    Login saveRegisterLogin(Login login);


}
