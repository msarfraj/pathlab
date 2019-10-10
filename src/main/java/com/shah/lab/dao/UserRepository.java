package com.shah.lab.dao;

import com.shah.lab.model.Role;
import com.shah.lab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{
    User findByMobile(Long mobile);
    List<User> findAllByRolesIsContaining(Role role );
}
