package com.shah.lab.model;

import javax.persistence.*;

@Entity
@Table(name="referrer")
public class Referrer
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REF_SEQ")
    @SequenceGenerator(initialValue = 1, sequenceName = "referrer_seq", allocationSize = 1, name = "REF_SEQ")
    private Long sequence;
    private String name;
    private String qualification;
    private String mobile;
    private String email;
    private String hospital;
    private String address;

    public Long getSequence()
    {
        return sequence;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getQualification()
    {
        return qualification;
    }

    public void setQualification(String qualification)
    {
        this.qualification = qualification;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getHospital()
    {
        return hospital;
    }

    public void setHospital(String hospital)
    {
        this.hospital = hospital;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
}
