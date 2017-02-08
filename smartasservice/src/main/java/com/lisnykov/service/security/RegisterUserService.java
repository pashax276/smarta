package com.lisnykov.service.security;

/**
 * Created by pasha on 2/7/17.
 */
public interface RegisterUserService {
    public void save(String username, String password, String email);
}
