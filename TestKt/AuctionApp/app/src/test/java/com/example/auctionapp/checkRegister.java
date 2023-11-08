package com.example.auctionapp;


import com.example.auctionapp.Activity.RegisterActivity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class checkRegister {
    @Mock
    private RegisterActivity mock;

    @Test
    public void test1checkRegister() {
        String password = "A017a9189@gmail.com";
        String uid = "132018290280";
        boolean expected = true;
        boolean result = mock.checkRegister(password, uid);
        Assert.assertEquals(expected, result);
    }
    @Test
    public void test2checkRegister() {
        String password = "Ana1333";
        String uid = "132018290280";
        boolean expected = false;
        boolean result = mock.checkRegister(password, uid);
        Assert.assertEquals(expected, result);

    }
    @Test
    public void test3checkRegister() {
        String password = "Thanh@32132";
        String uid = "132018290280";
        boolean expected = true;
        boolean result = mock.checkRegister(password, uid);
        Assert.assertEquals(expected, result);

    }
    @Test
    public void test4checkRegister() {
        String password = "thanh1872";
        String uid = "132018290280";
        boolean expected = false;
        boolean result = mock.checkRegister(password, uid);
        Assert.assertEquals(expected, result);

    }
    @Test
    public void test5checkRegister() {
        String password = "0819892292";
        String uid = "132018290280";
        boolean expected = false;
        boolean result = mock.checkRegister(password, uid);
        Assert.assertEquals(expected, result);

    }
    @Test
    public void test6checkRegister() {
        String password = "03382022222";
        String uid = "132018290280";
        boolean expected = false;
        boolean result = mock.checkRegister(password, uid);
        Assert.assertEquals(expected, result);
    }
    @Test
    public void test7checkRegister() {
        String password = "thanh@31##";
        String uid = "132018290280";
        boolean expected = false;
        boolean result = mock.checkRegister(password, uid);
        Assert.assertEquals(expected, result);

    }
    @Test
    public void test8checkRegister() {
        String password = "Thanh2223";
        String uid = "132018290280";
        boolean expected = false;
        boolean result = mock.checkRegister(password, uid);
        Assert.assertEquals(expected, result);

    }
    @Test
    public void test9checkRegister() {
        String password = "T@d122";
        String uid = "132018290280";
        boolean expected = false;
        boolean result = mock.checkRegister(password, uid);
        Assert.assertEquals(expected, result);

    }
    @Test
    public void test10checkRegister() {
        String password = "2112";
        String uid = "132018290280";
        boolean expected = false;
        boolean result = mock.checkRegister(password, uid);
        Assert.assertEquals(expected, result);

    }
}
