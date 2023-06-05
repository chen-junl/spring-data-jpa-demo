package com.example.demotest.controller;

import com.example.demotest.dto.StudentDto;
import com.example.demotest.service.BaseRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenjunl
 * @description
 * @date 2023/3/23
 */
@Controller
@ResponseBody
public class BaseRepositoryMqWebController {

    @Autowired
    private BaseRepositoryService baseRepositoryService;

    @PutMapping(value = "student/{id:\\d+}/save-mq")
    public StudentDto updateStudentByIdMq(@PathVariable Integer id) {
        return baseRepositoryService.updateStudentByIdMq(id);
    }

}
