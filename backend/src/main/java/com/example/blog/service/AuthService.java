package com.example.blog.service;

import com.example.blog.dto.RegisterRequest;

public interface AuthService {
    void signup(RegisterRequest registerRequest);
}
