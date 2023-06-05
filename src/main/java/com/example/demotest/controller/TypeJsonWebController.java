package com.example.demotest.controller;

import com.example.demotest.dto.type_json.StudentDetailTypeJsonDto;
import com.example.demotest.service.TypeJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenjunl
 * @description
 * @date 2023/3/23
 */
@Controller
@ResponseBody
@RequestMapping(value = "type-json")
public class TypeJsonWebController {

    @Autowired
    private TypeJsonService typeJsonService;

    @PutMapping(value = "student-detail/{id:\\d+}")
    public StudentDetailTypeJsonDto typeJsonFindById(@PathVariable Integer id) {
        return typeJsonService.typeJsonFindById(id);
    }


}
