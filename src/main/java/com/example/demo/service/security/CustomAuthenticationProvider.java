package com.example.demo.service.security;

import com.example.demo.model.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;


public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserDetailServiceImp userDetailServiceImp;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @SuppressWarnings("unchecked")
    public UsernamePasswordAuthenticationToken authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();


        User user = (User) userDetailServiceImp.loadUserByUsername(username);
        String encodePassword = passwordEncoder.encode(user.getPassword());

        if (!passwordEncoder.matches(password, encodePassword)) {
            logger.info("Provider password discord");
            throw new BadCredentialsException("Password is not matched");
        }
        if (!user.isEnabled()) {
            throw new BadCredentialsException(username);
        }

        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(
                user,
                password
                ,
                user.getAuthorities()
        );
        logger.info("Provider password same");
        return authenticationToken;


    }



    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
