package com.example.demo.service.security;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {
    Logger logger = LoggerFactory.getLogger(getClass());

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public CustomPasswordEncoder() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    }

    @Override
    public String encode(CharSequence rawPassword) {
        String hashed = bCryptPasswordEncoder.encode(rawPassword);
        return hashed;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        boolean match = bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
        logger.info("match : " + match);
        return match;
    }

}