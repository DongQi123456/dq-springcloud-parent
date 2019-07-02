package com.controller;

import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/page")
public class UserInfoController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/userPage")
    public ModelAndView userPage(ModelMap modelMap,
                                 @RequestParam("id") Long id){
        modelMap.addAttribute("department", departmentService.findDepartmentById(id));
        return new ModelAndView("user");
    }

}
