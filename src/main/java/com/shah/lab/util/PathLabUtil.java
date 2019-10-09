package com.shah.lab.util;

public class PathLabUtil
{
    public static String createCustomPassword(String name,String mobile){
        return  name.substring(0,4)+mobile.substring(6,9);
    }
}
