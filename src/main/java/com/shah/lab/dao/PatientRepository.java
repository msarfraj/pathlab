package com.shah.lab.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shah.lab.model.User;
@Repository
public interface PatientRepository extends CrudRepository<User, String> {
	@Query("select u from User u where u.name=:name and u.password=:password")
	User findUserByName(@Param("name")String id,@Param("password")String password);
}
