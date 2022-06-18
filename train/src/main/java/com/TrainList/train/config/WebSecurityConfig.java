package com.TrainList.train.config;

import com.TrainList.train.models.Role;
import com.TrainList.train.models.User;
import com.TrainList.train.repositories.UserRepository;
import com.TrainList.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import java.util.Collections;

import static com.TrainList.train.models.Role.ADMIN;
import static com.TrainList.train.models.Role.USER;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    User user ;

    @Autowired
    private UserService userService;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.cors().disable() .csrf().disable();
        http
                .authorizeRequests()
                    .antMatchers("/","/registration","/travel","/train/list","/train/toSend","/train/fromSend").permitAll()
                    .antMatchers("/train/buy/ticket/{id}","/user/account").hasAuthority(USER.getAuthority())
                    .antMatchers("/**").hasAuthority(ADMIN.getAuthority())
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                    .logoutSuccessUrl("/");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
 }
}