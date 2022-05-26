//package com.example.demo.config;
//
//import com.example.demo.service.security.CustomAuthenticationProvider;
//import com.example.demo.service.security.UserDetailServiceImp;
//
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Bean
//    public CustomAuthenticationProvider customAuthenticationProvider() {
//        return new CustomAuthenticationProvider();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailServiceImp();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        return new CustomAuthenticationProvider();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // description : 유저 인증정보 설정. 하드코딩 -> jdbc 인증정보 연결
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    // description : static file 같은 인증이 필요없는 리소스를 이곳에서 설정
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//        web.ignoring().antMatchers("/index.html");
//    }
//
//    //description : 리소스 보안 부분
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/css/**","/ext/**","/js/**","/img/**","/index").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/auth/**").permitAll()
//                .and()
//                .authorizeRequests().antMatchers("/survey/**").permitAll()
//                .and()
//                .formLogin().loginPage("/auth/login").usernameParameter("emailAddress").passwordParameter("loginPW").successForwardUrl("/main") // TODO index와 main을 합치면 index로 수정해주어야 함.
//                .loginPage("/auth/login")
//                .usernameParameter("emailAddress")
//                .passwordParameter("loginPW")
//                .loginProcessingUrl("/user/login")
//                .successForwardUrl("/user/main")
//                .failureForwardUrl("/user/login")// TODO index와 main을 합치면 index로 수정해주어야 함.
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
//
//    }
//
//}
package com.example.demo.config;

import com.example.demo.service.security.CustomAuthenticationProvider;
import com.example.demo.service.security.UserDetailServiceImp;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailServiceImp();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // description : 유저 인증정보 설정. 하드코딩 -> jdbc 인증정보 연결
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    // description : static file 같은 인증이 필요없는 리소스를 이곳에서 설정
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
        web.ignoring().antMatchers("/index.html");
    }

    //description : 리소스 보안 부분
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**", "/ext/**", "/js/**", "/img/**", "/index").permitAll()
                .and()
                .authorizeRequests().antMatchers("/**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/survey/**").permitAll()
                .and()
                .formLogin().loginPage("/signIn").usernameParameter("id").passwordParameter("password").successForwardUrl("/main") // TODO index와 main을 합치면 index로 수정해주어야 함.
                .loginPage("/signIn")
                .usernameParameter("id")
                .passwordParameter("password")
                .loginProcessingUrl("/user/signIn")
                .successForwardUrl("/user/main")
                .failureForwardUrl("/user/signIn")// TODO index와 main을 합치면 index로 수정해주어야 함.
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");

    }

}