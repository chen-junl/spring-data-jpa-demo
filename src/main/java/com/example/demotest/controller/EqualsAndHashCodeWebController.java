package com.example.demotest.controller;

import com.example.demotest.service.EqualsAndHashCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenjunl
 * @description
 * @date 2023/3/23
 */
@Controller
@ResponseBody
@RequestMapping(value = "equals-hashcode")
public class EqualsAndHashCodeWebController {

    @Autowired
    private EqualsAndHashCodeService equalsAndHashCodeService;


    @GetMapping(value = "student")
    public boolean testEqualsAndHashCode() {
        return equalsAndHashCodeService.testEqualsAndHashCode();
    }

}
