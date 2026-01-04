package com.todoapp.todoapp.security;

import com.todoapp.todoapp.model.User;
import com.todoapp.todoapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository
                .findByUserName(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        return new MyUserDetails(user); // ✅ SAME AS GA
    }
}
