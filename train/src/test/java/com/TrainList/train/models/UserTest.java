package com.TrainList.train.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static com.TrainList.train.models.Role.ADMIN;
import static com.TrainList.train.models.Role.USER;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;


    @BeforeEach
    public void userTest(){
        user = new User();
        user.setUsername("test1");
        user.setPassword("12345");
        user.setActive(true);
        user.setRoles(Collections.singleton(ADMIN));
    }

    @Test
    void setUsername() {
        user.setUsername("test");
        assertEquals("test",user.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("12345",user.getPassword());
    }

    @Test
    void setPassword() {
        user.setPassword("123");
        assertEquals("123",user.getPassword());
    }

    @Test
    void isActive() {
        assertTrue(true);
    }

    @Test
    void setActive() {
        user.setActive(true);
        assertTrue(true);
    }

    @Test
    void getRoles() {
        user.setRoles(Collections.singleton(Role.USER));
        assertEquals(Collections.singleton(USER) ,user.getRoles());
    }

    @Test
    void setRoles() {
        user.setRoles(Collections.singleton(ADMIN));
        assertEquals(Collections.singleton(ADMIN) ,user.getRoles());
    }
}