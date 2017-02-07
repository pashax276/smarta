package com.lisnykov.service.security;

import com.lisnykov.model.entity.User;
import com.lisnykov.repository.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by pasha on 2/7/17.
 */
@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        return new CustomUserDetails(user.getUsername(), user.getPassword(), true, true,
                true, true, user.getAuthorities()
        );
    }
}
