package com.shah.lab.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDTO
{
    @NotNull
    @NotEmpty
    private String name;
    private String password;

    @NotNull
    @NotEmpty
    private String mobile;
    private String email;
    private int age;
    private String gender;
    private String referredBy;
    private String role;
    private String address;
    private String testConducted;
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
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
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


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getReferredBy()
    {
        return referredBy;
    }

    public void setReferredBy(String referredBy)
    {
        this.referredBy = referredBy;
    }
    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getTestConducted()
    {
        return testConducted;
    }

    public void setTestConducted(String testConducted)
    {
        this.testConducted = testConducted;
    }
}