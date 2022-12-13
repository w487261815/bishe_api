package com.example.demo.service;

public interface AnnimalTokens {
    int delelteUsername(String userName);
    String insert(String username);
    int updateDuration(String token);
    String getToken(Long userId);
    String getUsername(String token);
}
