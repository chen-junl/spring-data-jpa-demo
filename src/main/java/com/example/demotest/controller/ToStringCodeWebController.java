package com.example.demotest.controller;

import com.example.demotest.entity.tostring.StudentAssociationToStringType1Entity;
import com.example.demotest.entity.tostring.StudentAssociationToStringType2Entity;
import com.example.demotest.repository.tostring.StudentAssociationToStringType1EntityRepository;
import com.example.demotest.repository.tostring.StudentAssociationToStringType2EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenjunl
 * @description
 * @date 2023/3/23
 */
@Controller
@ResponseBody
@RequestMapping(value = "to-string")
public class ToStringCodeWebController {

    @Autowired
    private StudentAssociationToStringType1EntityRepository studentAssociationToStringType1EntityRepository;
    @Autowired
    private StudentAssociationToStringType2EntityRepository studentAssociationToStringType2EntityRepository;

    @GetMapping(value = "student/type1/{id:\\d+}")
    public String testEqualsAndHashCode(@PathVariable Integer id) {
        return studentAssociationToStringType1EntityRepository.findById(id).orElse(new StudentAssociationToStringType1Entity()).toString();
    }

    @GetMapping(value = "student/type2/{id:\\d+}")
    public String testEqualsAndHashCode2(@PathVariable Integer id) {
        return studentAssociationToStringType2EntityRepository.findById(id).orElse(new StudentAssociationToStringType2Entity()).toString();
    }
}
