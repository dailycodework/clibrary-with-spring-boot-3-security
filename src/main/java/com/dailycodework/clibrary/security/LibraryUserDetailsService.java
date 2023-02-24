package com.dailycodework.clibrary.security;

import com.dailycodework.clibrary.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;



@Component
public class LibraryUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     return userRepository.findByEmail(username)
              .map(LibraryUserDetails::new)
              .orElseThrow(() -> new UsernameNotFoundException("No user found with : "+username));
    }
}

