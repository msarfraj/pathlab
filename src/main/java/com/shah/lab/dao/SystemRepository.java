package com.shah.lab.dao;

import org.springframework.data.repository.CrudRepository;

import com.shah.lab.model.UserModel;

public interface SystemRepository extends CrudRepository<UserModel, String> {

}
