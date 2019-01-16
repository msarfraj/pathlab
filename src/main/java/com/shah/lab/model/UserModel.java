package com.shah.lab.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.shah.lab.enums.UserType;

@Entity
public class UserModel {
private String name;
private String age;
private String gender;
private int mobile;
@Id
private String registrationId;
private String referredBy;
private UserType accessType;
private String password;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getMobile() {
	return mobile;
}
public void setMobile(int mobile) {
	this.mobile = mobile;
}
public String getRegistrationId() {
	return registrationId;
}
public void setRegistrationId(String registrationId) {
	this.registrationId = registrationId;
}
public String getReferredBy() {
	return referredBy;
}
public void setReferredBy(String referredBy) {
	this.referredBy = referredBy;
}
public UserType getAccessType() {
	return accessType;
}
public void setAccessType(UserType accessType) {
	this.accessType = accessType;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
