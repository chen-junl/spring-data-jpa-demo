package com.example.demotest.controller;

import com.example.demotest.dto.association.StudentAssociationBooksDto;
import com.example.demotest.service.NamedEntityGraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author chenjunl
 * @description
 * @date 2023/6/15
 */
@Controller
@ResponseBody
@RequestMapping(value = "named-entity-graph")
public class NamedEntityGraphWebController {

    @Autowired
    private NamedEntityGraphService namedEntityGraphService;

    @GetMapping(value = "student/lazy/{id:\\d+}")
    public StudentAssociationBooksDto findLazyById(@PathVariable Integer id) {
        return namedEntityGraphService.findLazyById(id);
    }

    @GetMapping(value = "student/lazy")
    public List<StudentAssociationBooksDto> findLazy() {
        return namedEntityGraphService.findLazy();
    }


    @GetMapping(value = "student/eager/{id:\\d+}")
    public StudentAssociationBooksDto findEagerById(@PathVariable Integer id) {
        return namedEntityGraphService.findEagerById(id);
    }

    @GetMapping(value = "student/eager")
    public List<StudentAssociationBooksDto> findEager() {
        return namedEntityGraphService.findEager();
    }

    @GetMapping(value = "student/type1/{id:\\d+}")
    public StudentAssociationBooksDto findStudent1ById(@PathVariable Integer id) {
        return namedEntityGraphService.findStudent1ById(id);
    }

    @GetMapping(value = "student/type1")
    public List<StudentAssociationBooksDto> findStudent1() {
        return namedEntityGraphService.findStudent1();
    }

    @GetMapping(value = "student/type2/{id:\\d+}")
    public StudentAssociationBooksDto findStudent2ById(@PathVariable Integer id) {
        return namedEntityGraphService.findStudent2ById(id);
    }

    @GetMapping(value = "student/type2")
    public List<StudentAssociationBooksDto> findStudent2() {
        return namedEntityGraphService.findStudent2();
    }

    @GetMapping(value = "student/type3/{id:\\d+}")
    public StudentAssociationBooksDto findStudent3ById(@PathVariable Integer id) {
        return namedEntityGraphService.findStudent3ById(id);
    }

    @GetMapping(value = "student/type3")
    public List<StudentAssociationBooksDto> findStudent3() {
        return namedEntityGraphService.findStudent3();
    }
}
