package com.shah.lab.service;

import com.shah.lab.dto.LabTestDTO;
import com.shah.lab.dto.ReferrerDTO;
import com.shah.lab.model.LabTest;
import com.shah.lab.model.Referrer;

import java.util.List;

public interface LabDataService
{
    boolean addTest(LabTestDTO labTestDTO);
    boolean addDoctor(ReferrerDTO referrerDTO);
    List<LabTest> findAllTests();
    List<Referrer> findAllDocs();
}
