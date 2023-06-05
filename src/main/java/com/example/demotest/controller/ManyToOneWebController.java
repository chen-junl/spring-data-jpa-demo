package com.example.demotest.controller;

import com.example.demotest.dto.association.BookAssociationStudentDto;
import com.example.demotest.dto.association.StudentAssociationBooksDto;
import com.example.demotest.service.ManyToOneService;
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
@RequestMapping(value = "many-to-one")
public class ManyToOneWebController {

    @Autowired
    private ManyToOneService manyToOneService;

    //单向级联关联
    @GetMapping(value = "book/type1/{id:\\d+}")
    public BookAssociationStudentDto findBook1ById(@PathVariable Integer id) {
        return manyToOneService.findBook1ById(id);
    }

    @GetMapping(value = "student/type1/{id:\\d+}")
    public StudentAssociationBooksDto findStudent1ById(@PathVariable Integer id) {
        return manyToOneService.findStudent1ById(id);
    }

    //双向级联关联
    @GetMapping(value = "book/type2/{id:\\d+}")
    public BookAssociationStudentDto findBook2ById(@PathVariable Integer id) {
        return manyToOneService.findBook2ById(id);
    }

    @GetMapping(value = "student/type2/{id:\\d+}")
    public StudentAssociationBooksDto findStudent2ById(@PathVariable Integer id) {
        return manyToOneService.findStudent2ById(id);
    }

    //fetch第一种 Fetch.EAGER
    @GetMapping(value = "book/fetch1/{id:\\d+}")
    public BookAssociationStudentDto findBookAttributeFetch1ById(@PathVariable Integer id) {
        return manyToOneService.findBookAttributeFetch1ById(id);
    }

    @GetMapping(value = "book/fetch1")
    public List<BookAssociationStudentDto> findBookAttributeFetch1() {
        return manyToOneService.findBookAttributeFetch1();
    }

    //fetch第二种 Fetch.LAZY
    @GetMapping(value = "book/fetch2/{id:\\d+}")
    public BookAssociationStudentDto findBookAttributeFetch2ById(@PathVariable Integer id) {
        return manyToOneService.findBookAttributeFetch2ById(id);
    }

    @GetMapping(value = "book/fetch2")
    public List<BookAssociationStudentDto> findBookAttributeFetch2() {
        return manyToOneService.findBookAttributeFetch2();
    }


    //optional第一种  optional=true
    @GetMapping(value = "book/optional1/{id:\\d+}")
    public BookAssociationStudentDto findBookAttributeOptional1ById(@PathVariable Integer id) {
        return manyToOneService.findBookAttributeOptional1ById(id);
    }

    @PostMapping(value = "book/optional1")
    public BookAssociationStudentDto insertBookAttributeOptional1ById(@RequestBody BookAssociationStudentDto dto) {
        return manyToOneService.insertBookAttributeOptional1ById(dto);
    }


    //optional第二种 optional=false
    @GetMapping(value = "book/optional2/{id:\\d+}")
    public BookAssociationStudentDto findBookAttributeOptional2ById(@PathVariable Integer id) {
        return manyToOneService.findBookAttributeOptional2ById(id);
    }

    @PostMapping(value = "book/optional2")
    public BookAssociationStudentDto insertBookAttributeOptional2ById(@RequestBody BookAssociationStudentDto dto) {
        return manyToOneService.insertBookAttributeOptional2ById(dto);
    }

}
