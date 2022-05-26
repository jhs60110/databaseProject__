package com.example.demo.service.security;

import com.example.demo.model.user.User;
import com.example.demo.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserDetailServiceImp implements UserDetailsService{

    Logger logger = LoggerFactory.getLogger(UserDetailServiceImp.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        logger.info("UserDetailServiceImp : loadUserByUserID " + id);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        User user = userService.getLoginInfo(id);
        if(user != null ) {
            logger.info("되냐?");
            logger.info("UserDetailServiceImp user : " + user.getE_name() +  ", " +  user.getAuthorities());
            return user;
        }else {
            logger.info("user not found");
            User error = new User();
            error.setPassword("testPW");
            return error;
        }
    }

    private User findUserByUsername(String id) {
        logger.info("findUserByUsername : " + id );
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
//		User employee = employService.getLoginInfo(userLoginId, request);
        User user = userService.getLoginInfo(id);
        logger.info("user : " + user);
        return user;
    }
}
