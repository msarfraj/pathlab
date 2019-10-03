package com.shah.lab.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDTO
{

    private String name;
    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String mobile;


    @NotNull
    @NotEmpty
    private String role;
    @NotNull
    @NotEmpty
    private String email;
    private int age;
    private String gender;
    private String referredBy;

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getReferredBy()
    {
        return referredBy;
    }

    public void setReferradBy(String referredBy)
    {
        this.referredBy = referredBy;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String nameame)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }


}