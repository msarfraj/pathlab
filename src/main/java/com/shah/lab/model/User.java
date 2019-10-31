package com.shah.lab.model;

import javax.persistence.*;

import com.shah.lab.enums.UserType;

import java.util.Set;

@Entity
@Table(name = "user")
public class User
{
    private String name;
    private int age;
    private String gender;
    private long mobile;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(initialValue = 1, sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
    private Long registrationId;
    private String referredBy;
    private String password;
    private String email;

	@ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
	private String testConducted;
	private String address;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

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

    public long getMobile()
    {
        return mobile;
    }

    public void setMobile(long mobile)
    {
        this.mobile = mobile;
    }

    public Long getRegistrationId()
    {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId)
    {
        this.registrationId = registrationId;
    }

    public String getReferredBy()
    {
        return referredBy;
    }

    public void setReferredBy(String referredBy)
    {
        this.referredBy = referredBy;
    }


    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
	public Set<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTestConducted()
    {
        return testConducted;
    }

    public void setTestConducted(String testConducted)
    {
        this.testConducted = testConducted;
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
