package com.shah.lab.controller;

import com.shah.lab.dto.LabTestDTO;
import com.shah.lab.dto.ReferrerDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class GenericController extends PathLabController
{


    @RequestMapping(value = "/add/test", method = RequestMethod.GET)
    public String adNewTest(WebRequest request, Model model) {
        LabTestDTO labTestDTO=new LabTestDTO();
        model.addAttribute("labTestDTO", labTestDTO);
        return "addTest";
    }
    @RequestMapping(value = "/add/doctor", method = RequestMethod.GET)
    public String addADoctor(WebRequest request, Model model) {
        ReferrerDTO referrerDTO=new ReferrerDTO();
        model.addAttribute("referrerDTO", referrerDTO);
        return "addDoctor";
    }
    @RequestMapping(value = "/add/doctor", method = RequestMethod.POST)
    public ModelAndView addDoctor(@ModelAttribute("referrerDTO") @Valid ReferrerDTO data,
                                     BindingResult result, WebRequest request, Errors errors) {
        boolean added=false;
        if (!result.hasErrors()) {
            added = labDataService.addDoctor(data);
        }
        if (added) {
            return new ModelAndView("homepage", "msg", String.format("Successfully added- %s",data.getName()));
        }
        if (result.hasErrors()) {
            return new ModelAndView("homepage", "msg", String.format("Error in form data !! Try again"));
        }
        return new ModelAndView("homepage","msg","Some error occured");
    }
    @RequestMapping(value = "/add/test", method = RequestMethod.POST)
    public ModelAndView addTest(@ModelAttribute("labTestDTO") @Valid LabTestDTO data,
                                     BindingResult result, WebRequest request, Errors errors) {
        boolean added=false;
        if (!result.hasErrors()) {
            added = labDataService.addTest(data);
        }
        if (added) {
            return new ModelAndView("homepage", "msg", String.format("Successfully added- %s",data.getName()));
        }
        if (result.hasErrors()) {
            return new ModelAndView("homepage", "msg", String.format("Error in form data !! Try again"));
        }
        return new ModelAndView("homepage","msg","Some error occured");
    }

    @RequestMapping("/allTests")
    public String viewAllTests(WebRequest request, Model model){
        List<LabTestDTO> labTests = getAllLabTests();
        model.addAttribute("labtests", labTests);
        return "labTest";
    }



    @RequestMapping("/registeredDocs")
    public String getAllDocs(WebRequest request, Model model){
        List<ReferrerDTO> alldocs = getAllDocs();
        model.addAttribute("alldocs", alldocs);
        return "doctors";
    }
}
