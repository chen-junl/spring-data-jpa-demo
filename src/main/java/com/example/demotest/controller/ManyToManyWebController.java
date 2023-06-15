package com.example.demotest.controller;


import com.example.demotest.dto.association.CourseAssociationStudentDto;
import com.example.demotest.dto.association.StudentAssociationCourseDto;
import com.example.demotest.service.ManyToManyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chenjunl
 * @description
 * @date 2023/3/23
 */
@Controller
@ResponseBody
@RequestMapping(value = "many-to-many")
public class ManyToManyWebController {

    @Autowired
    private ManyToManyService manyToManyService;

    //单向级联关联
    @GetMapping(value = "course/type1/{id:\\d+}")
    public CourseAssociationStudentDto findCourse1ById(@PathVariable Integer id) {
        return manyToManyService.findCourse1ById(id);
    }

    @GetMapping(value = "student/type1/{id:\\d+}")
    public StudentAssociationCourseDto findStudent1ById(@PathVariable Integer id) {
        return manyToManyService.findStudent1ById(id);
    }

    //双向级联关联
    @GetMapping(value = "course/type2/{id:\\d+}")
    public CourseAssociationStudentDto findCourse2ById(@PathVariable Integer id) {
        return manyToManyService.findCourse2ById(id);
    }

    @GetMapping(value = "student/type2/{id:\\d+}")
    public StudentAssociationCourseDto findStudent2ById(@PathVariable Integer id) {
        return manyToManyService.findStudent2ById(id);
    }


    //cascade第0种类型什么都不加
    @GetMapping(value = "course/cascade0/{id:\\d+}")
    public CourseAssociationStudentDto findCourseAttributeCascade0ById(@PathVariable Integer id) {
        return manyToManyService.findCourseAttributeCascade0ById(id);
    }

    @PostMapping(value = "course/cascade0")
    public CourseAssociationStudentDto insertCourseAttributeCascade0ById(@RequestBody CourseAssociationStudentDto dto) {
        return manyToManyService.insertCourseAttributeCascade0ById(dto);
    }

    @PutMapping(value = "course/cascade0/{id:\\d+}")
    public CourseAssociationStudentDto updateCourseAttributeCascade0ById(@PathVariable Integer id, @RequestBody CourseAssociationStudentDto dto) {
        return manyToManyService.updateCourseAttributeCascade0ById(id, dto);
    }

    @DeleteMapping(value = "course/cascade0/{id:\\d+}")
    public boolean deleteCourseAttributeCascade0ById(@PathVariable Integer id) {
        return manyToManyService.deleteCourseAttributeCascade0ById(id);
    }


    //cascade第一种类型 CascadeType.ALL
    @GetMapping(value = "course/cascade1/{id:\\d+}")
    public CourseAssociationStudentDto findCourseAttributeCascade1ById(@PathVariable Integer id) {
        return manyToManyService.findCourseAttributeCascade1ById(id);
    }

    @PostMapping(value = "course/cascade1")
    public CourseAssociationStudentDto insertCourseAttributeCascade1ById(@RequestBody CourseAssociationStudentDto dto) {
        return manyToManyService.insertCourseAttributeCascade1ById(dto);
    }

    @PutMapping(value = "course/cascade1/{id:\\d+}")
    public CourseAssociationStudentDto updateCourseAttributeCascade1ById(@PathVariable Integer id, @RequestBody CourseAssociationStudentDto dto) {
        return manyToManyService.updateCourseAttributeCascade1ById(id, dto);
    }

    @DeleteMapping(value = "course/cascade1/{id:\\d+}")
    public boolean deleteCourseAttributeCascade1ById(@PathVariable Integer id) {
        return manyToManyService.deleteCourseAttributeCascade1ById(id);
    }

    //fetch第一种 Fetch.EAGER
    @GetMapping(value = "course/fetch1/{id:\\d+}")
    public CourseAssociationStudentDto findCourseAttributeFetch1ById(@PathVariable Integer id) {
        return manyToManyService.findCourseAttributeFetch1ById(id);
    }

    @GetMapping(value = "course/fetch1")
    public List<CourseAssociationStudentDto> findCourseAttributeFetch1() {
        return manyToManyService.findCourseAttributeFetch1();
    }

    //fetch第二种 Fetch.LAZY
    @GetMapping(value = "course/fetch2/{id:\\d+}")
    public CourseAssociationStudentDto findCourseAttributeFetch2ById(@PathVariable Integer id) {
        return manyToManyService.findCourseAttributeFetch2ById(id);
    }

    @GetMapping(value = "course/fetch2")
    public List<CourseAssociationStudentDto> findCourseAttributeFetch2() {
        return manyToManyService.findCourseAttributeFetch2();
    }

    @GetMapping(value = "course/where/{id:\\d+}")
    public CourseAssociationStudentDto findCourseWhereById(@PathVariable Integer id) {
        return manyToManyService.findCourseWhereById(id);
    }

    @GetMapping(value = "course/where-join-table/{id:\\d+}")
    public CourseAssociationStudentDto findCourseWhereJoniTableById(@PathVariable Integer id) {
        return manyToManyService.findCourseWhereJoniTableById(id);
    }

    @GetMapping(value = "course/where-join-table/title")
    public CourseAssociationStudentDto findCourseWhereJoniTableByTitle(@RequestParam String title) {
        return manyToManyService.findCourseWhereJoniTableByTitle(title);
    }

}
