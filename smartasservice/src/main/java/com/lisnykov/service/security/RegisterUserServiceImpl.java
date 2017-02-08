package com.lisnykov.service.security;

import com.lisnykov.model.entity.User;
import com.lisnykov.repository.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by pasha on 2/7/17.
 */
@Service
public class RegisterUserServiceImpl implements RegisterUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setEmail(email);
        userRepository.save(user);
    }
}
