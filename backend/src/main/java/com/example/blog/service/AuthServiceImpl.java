package com.example.blog.service;

import com.example.blog.dto.RegisterRequest;
import com.example.blog.entity.AppUser;
import com.example.blog.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public void signup(RegisterRequest registerRequest) {
        AppUser appUser = new AppUser();
        appUser.setUserName(registerRequest.getUsername());
        appUser.setPassword(registerRequest.getPassword());
        appUser.setEmail(registerRequest.getEmail());
        appUserRepository.save(appUser);

    }


}
