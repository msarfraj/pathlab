package com.shah.lab.dao;

import com.shah.lab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{
    User findByMobile(Long mobile);
}
