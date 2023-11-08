package com.example.auctionapp;

import com.example.auctionapp.Activity.Login;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RunWith(MockitoJUnitRunner.class)
public class LoginActivityTest {


    @Mock
    private Login mockLogin;

    @Test
    public void test1CheckAuthPass() {
        String username = "A017a9189@gmail.com";

        boolean expected = true;
        boolean result = mockLogin.checkAuthPass(username);
        Assert.assertEquals(expected, result);
    }
    @Test
    public void test2CheckAuthPass() {
        String username = "Ana1333";

        boolean expected = false;
        boolean result = mockLogin.checkAuthPass(username);
        Assert.assertEquals(expected, result);

    }
    @Test
    public void test3CheckAuthPass() {
        String username = "ab12";

        boolean expected = false;
        boolean result = mockLogin.checkAuthPass(username);
        Assert.assertEquals(expected, result);

    }
    @Test
    public void test4CheckAuthPass() {
        String username = "thanh1872";

        boolean expected = true;
        boolean result = mockLogin.checkAuthPass(username);
        Assert.assertEquals(expected, result);

    }
    @Test
    public void test5CheckAuthPass() {
        String username = "0819892292";

        boolean expected = true;
        boolean result = mockLogin.checkAuthPass(username);
        Assert.assertEquals(expected, result);

    }
    @Test
    public void test6CheckAuthPass() {
        String username = "03382022222";

        boolean expected = false;
        boolean result = mockLogin.checkAuthPass(username);
        Assert.assertEquals(expected, result);
    }
    @Test
    public void test7CheckAuthPass() {
        String username = "thanh@31##";

        boolean expected = false;
        boolean result = mockLogin.checkAuthPass(username);
        Assert.assertEquals(expected, result);

    }
    @Test
    public void test8CheckAuthPass() {
        String username = "Thanh2223";

        boolean expected = false;
        boolean result = mockLogin.checkAuthPass(username);
        Assert.assertEquals(expected, result);

    }
    @Test
    public void test9CheckAuthPass() {
        String username = "t@dd0122";

        boolean expected = false;
        boolean result = mockLogin.checkAuthPass(username);
        Assert.assertEquals(expected, result);

    }
    @Test
    public void test10CheckAuthPass() {
        String username = "9113132112";
        boolean expected = false;
        boolean result = mockLogin.checkAuthPass(username);
        Assert.assertEquals(expected, result);

    }
}
