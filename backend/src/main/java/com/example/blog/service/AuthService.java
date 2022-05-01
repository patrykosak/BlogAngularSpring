package com.example.blog.service;

import com.example.blog.dto.LoginRequest;
import com.example.blog.dto.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    void signup(RegisterRequest registerRequest);

    String login(LoginRequest loginRequest);
}
