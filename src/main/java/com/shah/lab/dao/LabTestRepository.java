package com.shah.lab.dao;

import com.shah.lab.model.LabTest;
import com.shah.lab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTestRepository extends JpaRepository<LabTest,Long>
{
}
