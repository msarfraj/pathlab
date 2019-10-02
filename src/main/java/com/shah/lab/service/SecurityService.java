package com.shah.lab.service;

public interface SecurityService
{
    String findLoggedInUser();
    void autoLogin(String user,String password);
}
