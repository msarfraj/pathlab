package com.shah.lab.dao;


import com.shah.lab.model.Referrer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferrerRepository extends JpaRepository<Referrer, String> {


}
