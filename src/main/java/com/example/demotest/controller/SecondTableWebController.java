package com.example.demotest.controller;

import com.example.demotest.dto.secondary_table.StudentAndDetailSecondaryTableDto;
import com.example.demotest.entity.secondary_table.StudentAndDetailSecondaryTableEntity;
import com.example.demotest.service.SecondTableService;
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
@RequestMapping(value = "second-table")
public class SecondTableWebController {

    @Autowired
    private SecondTableService secondTableService;

    @GetMapping(value = "/student/{id:\\d+}")
    public StudentAndDetailSecondaryTableDto findStudentDetailById(@PathVariable Integer id) {
        return secondTableService.findStudentDetailById(id);
    }

    @PostMapping(value = "student")
    public StudentAndDetailSecondaryTableDto insertStudentDetail(@RequestBody StudentAndDetailSecondaryTableEntity entity) {
        return secondTableService.insertStudentDetail(entity);
    }

    @PutMapping(value = "student/{id:\\d+}")
    public StudentAndDetailSecondaryTableDto updateStudentDetailById(@PathVariable Integer id) {
        return secondTableService.updateStudentDetailById(id);
    }

}
