package com.example.demotest.controller;

import com.example.demotest.entity.TeacherEntity;
import com.example.demotest.service.VersionService;
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
@RequestMapping(value = "version")
public class VersionWebController {

    @Autowired
    private VersionService versionService;

    @PutMapping(value = "teacher/{id:\\d+}")
    public TeacherEntity updateTeacher(@PathVariable Integer id) {
        return versionService.updateTeacher(id);
    }


}
