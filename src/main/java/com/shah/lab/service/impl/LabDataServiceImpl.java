package com.shah.lab.service.impl;

import com.shah.lab.dao.LabTestRepository;
import com.shah.lab.dao.ReferrerRepository;
import com.shah.lab.dto.LabTestDTO;
import com.shah.lab.dto.ReferrerDTO;
import com.shah.lab.model.LabTest;
import com.shah.lab.model.Referrer;
import com.shah.lab.service.LabDataService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LabDataServiceImpl implements LabDataService
{
    @Autowired
    private LabTestRepository labTestRepository;
    @Autowired
    private ReferrerRepository referrerRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public boolean addTest(LabTestDTO labTestDTO)
    {
        LabTest test= modelMapper.map(labTestDTO, LabTest.class);
        LabTest saved=labTestRepository.save(test);
        return Objects.nonNull(saved);
    }

    @Override
    public boolean addDoctor(ReferrerDTO referrerDTO)
    {
        Referrer test= modelMapper.map(referrerDTO, Referrer.class);
        Referrer saved=referrerRepository.save(test);
        return Objects.nonNull(saved);
    }

    @Override
    public List<LabTest> findAllTests()
    {
        return labTestRepository.findAll();
    }

    @Override
    public List<Referrer> findAllDocs()
    {
        return referrerRepository.findAll();
    }
}
