package com.example.demotest.controller;

import com.example.demotest.dto.StudentDto;
import com.example.demotest.entity.StudentEntity;
import com.example.demotest.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenjunl
 * @description
 * @date 2023/3/23
 */
@Controller
@ResponseBody
@RequestMapping(value = "common")
public class CommonWebController {

    @Autowired
    private CommonService commonService;

    @GetMapping(value = "student/{id:\\d+}")
    public StudentDto findStudentById(@PathVariable Integer id) {
        return commonService.findById(id);
    }

    @PostMapping(value = "student")
    public StudentDto insertStudent(@RequestBody StudentEntity entity) {
        return commonService.insertStudent(entity);
    }

    @PutMapping(value = "student/{id:\\d+}")
    public StudentDto updateStudent(@PathVariable Integer id) {
        return commonService.updateStudent(id);
    }

    @DeleteMapping(value = "student/{id:\\d+}")
    public void deleteById(@PathVariable Integer id) {
        commonService.deleteById(id);
    }


}
