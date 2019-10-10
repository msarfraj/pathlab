package com.shah.lab.controller;

import com.shah.lab.dto.LabTestDTO;
import com.shah.lab.dto.ReferrerDTO;
import com.shah.lab.model.LabTest;
import com.shah.lab.model.Referrer;
import com.shah.lab.service.LabDataService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PathLabController
{
    @Autowired
    protected LabDataService labDataService;
    @Autowired
    protected ModelMapper modelMapper;
    protected List<LabTestDTO> getAllLabTests()
    {
        List<LabTest> allTests=labDataService.findAllTests();
        List<LabTestDTO> labTests=new ArrayList<>();
        for(LabTest test:allTests){
            LabTestDTO labTestDTO= modelMapper.map(test,LabTestDTO.class);
            labTests.add(labTestDTO);
        }
        return labTests;
    }
    protected List<ReferrerDTO> getAllDocs()
    {
        List<Referrer> allListedDocs=labDataService.findAllDocs();
        List<ReferrerDTO> alldocs=new ArrayList<>();
        for(Referrer doc:allListedDocs){
            ReferrerDTO labTestDTO= modelMapper.map(doc,ReferrerDTO.class);
            alldocs.add(labTestDTO);
        }
        return alldocs;
    }
}
