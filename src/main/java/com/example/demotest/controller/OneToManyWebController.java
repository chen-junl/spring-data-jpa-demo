package com.example.demotest.controller;

import com.example.demotest.dto.association.BookAssociationStudentDto;
import com.example.demotest.dto.association.StudentAssociationBooksDto;
import com.example.demotest.service.OneToManyService;
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
@RequestMapping(value = "one-to-many")
public class OneToManyWebController {

    @Autowired
    private OneToManyService oneToManyService;

    //单向级联关联
    @GetMapping(value = "student/type1/{id:\\d+}")
    public StudentAssociationBooksDto findStudent1ById(@PathVariable Integer id) {
        return oneToManyService.findStudent1ById(id);
    }

    @GetMapping(value = "book/type1/{id:\\d+}")
    public BookAssociationStudentDto findBook1ById(@PathVariable Integer id) {
        return oneToManyService.findBook1ById(id);
    }


    //双单向级联关联
    @GetMapping(value = "student/type2/{id:\\d+}")
    public StudentAssociationBooksDto findStudent2ById(@PathVariable Integer id) {
        return oneToManyService.findStudent2ById(id);
    }

    @GetMapping(value = "book/type2/{id:\\d+}")
    public BookAssociationStudentDto findBook2ById(@PathVariable Integer id) {
        return oneToManyService.findBook2ById(id);
    }

    //双向级联关联
    @GetMapping(value = "student/type3/{id:\\d+}")
    public StudentAssociationBooksDto findStudent3ById(@PathVariable Integer id) {
        return oneToManyService.findStudent3ById(id);
    }

    @GetMapping(value = "book/type3/{id:\\d+}")
    public BookAssociationStudentDto findBook3ById(@PathVariable Integer id) {
        return oneToManyService.findBook3ById(id);
    }


    //cascade第0种类型什么都不加
    @GetMapping(value = "student/cascade0/{id:\\d+}")
    public StudentAssociationBooksDto findStudentAttributeCascade0ById(@PathVariable Integer id) {
        return oneToManyService.findStudentAttributeCascade0ById(id);
    }

    @PostMapping(value = "student/cascade0")
    public StudentAssociationBooksDto insertStudentAttributeCascade0ById(@RequestBody StudentAssociationBooksDto dto) {
        return oneToManyService.insertStudentAttributeCascade0ById(dto);
    }

    @PutMapping(value = "student/cascade0/{id:\\d+}")
    public StudentAssociationBooksDto updateStudentAttributeCascade0ById(@PathVariable Integer id, @RequestBody StudentAssociationBooksDto dto) {
        return oneToManyService.updateStudentAttributeCascade0ById(id, dto);
    }

    @DeleteMapping(value = "student/cascade0/{id:\\d+}")
    public boolean deleteStudentAttributeCascade0ById(@PathVariable Integer id) {
        return oneToManyService.deleteStudentAttributeCascade0ById(id);
    }


    //cascade第一种类型 CascadeType.ALL
    @GetMapping(value = "student/cascade1/{id:\\d+}")
    public StudentAssociationBooksDto findStudentAttributeCascade1ById(@PathVariable Integer id) {
        return oneToManyService.findStudentAttributeCascade1ById(id);
    }

    @PostMapping(value = "student/cascade1")
    public StudentAssociationBooksDto insertStudentAttributeCascade1ById(@RequestBody StudentAssociationBooksDto dto) {
        return oneToManyService.insertStudentAttributeCascade1ById(dto);
    }

    @PutMapping(value = "student/cascade1/{id:\\d+}")
    public StudentAssociationBooksDto updateStudentAttributeCascade1ById(@PathVariable Integer id, @RequestBody StudentAssociationBooksDto dto) {
        return oneToManyService.updateStudentAttributeCascade1ById(id, dto);
    }

    @DeleteMapping(value = "student/cascade1/{id:\\d+}")
    public boolean deleteStudentAttributeCascade1ById(@PathVariable Integer id) {
        return oneToManyService.deleteStudentAttributeCascade1ById(id);
    }

    //cascade第二种类型 CascadeType.PERSIST
    @GetMapping(value = "student/cascade2/{id:\\d+}")
    public StudentAssociationBooksDto findStudentAttributeCascade2ById(@PathVariable Integer id) {
        return oneToManyService.findStudentAttributeCascade2ById(id);
    }

    @PostMapping(value = "student/cascade2")
    public StudentAssociationBooksDto insertStudentAttributeCascade2ById(@RequestBody StudentAssociationBooksDto dto) {
        return oneToManyService.insertStudentAttributeCascade2ById(dto);
    }

    @PutMapping(value = "student/cascade2/{id:\\d+}")
    public StudentAssociationBooksDto updateStudentAttributeCascade2ById(@PathVariable Integer id, @RequestBody StudentAssociationBooksDto dto) {
        return oneToManyService.updateStudentAttributeCascade2ById(id, dto);
    }

    @DeleteMapping(value = "student/cascade2/{id:\\d+}")
    public boolean deleteStudentAttributeCascade2ById(@PathVariable Integer id) {
        return oneToManyService.deleteStudentAttributeCascade2ById(id);
    }

    //cascade第三种类型 CascadeType.MERGE
    @GetMapping(value = "student/cascade3/{id:\\d+}")
    public StudentAssociationBooksDto findStudentAttributeCascade3ById(@PathVariable Integer id) {
        return oneToManyService.findStudentAttributeCascade3ById(id);
    }

    @PostMapping(value = "student/cascade3")
    public StudentAssociationBooksDto insertStudentAttributeCascade3ById(@RequestBody StudentAssociationBooksDto dto) {
        return oneToManyService.insertStudentAttributeCascade3ById(dto);
    }

    @PutMapping(value = "student/cascade3/{id:\\d+}")
    public StudentAssociationBooksDto updateStudentAttributeCascade3ById(@PathVariable Integer id, @RequestBody StudentAssociationBooksDto dto) {
        return oneToManyService.updateStudentAttributeCascade3ById(id, dto);
    }

    @DeleteMapping(value = "student/cascade3/{id:\\d+}")
    public boolean deleteStudentAttributeCascade3ById(@PathVariable Integer id) {
        return oneToManyService.deleteStudentAttributeCascade3ById(id);
    }

    //cascade第四种类型 CascadeType.REMOVE
    @GetMapping(value = "student/cascade4/{id:\\d+}")
    public StudentAssociationBooksDto findStudentAttributeCascade4ById(@PathVariable Integer id) {
        return oneToManyService.findStudentAttributeCascade4ById(id);
    }

    @PostMapping(value = "student/cascade4")
    public StudentAssociationBooksDto insertStudentAttributeCascade4ById(@RequestBody StudentAssociationBooksDto dto) {
        return oneToManyService.insertStudentAttributeCascade4ById(dto);
    }

    @PutMapping(value = "student/cascade4/{id:\\d+}")
    public StudentAssociationBooksDto updateStudentAttributeCascade4ById(@PathVariable Integer id, @RequestBody StudentAssociationBooksDto dto) {
        return oneToManyService.updateStudentAttributeCascade4ById(id, dto);
    }

    @DeleteMapping(value = "student/cascade4/{id:\\d+}")
    public boolean deleteStudentAttributeCascade4ById(@PathVariable Integer id) {
        return oneToManyService.deleteStudentAttributeCascade4ById(id);
    }


    //cascade第五种类型 CascadeType.REFRESH
    @GetMapping(value = "student/cascade5/{id:\\d+}")
    public StudentAssociationBooksDto findStudentAttributeCascade5ById(@PathVariable Integer id) {
        return oneToManyService.findStudentAttributeCascade5ById(id);
    }

    @PostMapping(value = "student/cascade5")
    public StudentAssociationBooksDto insertStudentAttributeCascade5ById(@RequestBody StudentAssociationBooksDto dto) {
        return oneToManyService.insertStudentAttributeCascade5ById(dto);
    }

    @PutMapping(value = "student/cascade5/{id:\\d+}")
    public StudentAssociationBooksDto updateStudentAttributeCascade5ById(@PathVariable Integer id, @RequestBody StudentAssociationBooksDto dto) {
        return oneToManyService.updateStudentAttributeCascade5ById(id, dto);
    }

    @DeleteMapping(value = "student/cascade5/{id:\\d+}")
    public boolean deleteStudentAttributeCascade5ById(@PathVariable Integer id) {
        return oneToManyService.deleteStudentAttributeCascade5ById(id);
    }


    //cascade第六种类型 CascadeType.DETACH
    @GetMapping(value = "student/cascade6/{id:\\d+}")
    public StudentAssociationBooksDto findStudentAttributeCascade6ById(@PathVariable Integer id) {
        return oneToManyService.findStudentAttributeCascade6ById(id);
    }

    @PostMapping(value = "student/cascade6")
    public StudentAssociationBooksDto insertStudentAttributeCascade6ById(@RequestBody StudentAssociationBooksDto dto) {
        return oneToManyService.insertStudentAttributeCascade6ById(dto);
    }

    @PutMapping(value = "student/cascade6/{id:\\d+}")
    public StudentAssociationBooksDto updateStudentAttributeCascade6ById(@PathVariable Integer id, @RequestBody StudentAssociationBooksDto dto) {
        return oneToManyService.updateStudentAttributeCascade6ById(id, dto);
    }

    @DeleteMapping(value = "student/cascade6/{id:\\d+}")
    public boolean deleteStudentAttributeCascade6ById(@PathVariable Integer id) {
        return oneToManyService.deleteStudentAttributeCascade6ById(id);
    }


    //fetch第一种 Fetch.EAGER
    @GetMapping(value = "student/fetch1/{id:\\d+}")
    public StudentAssociationBooksDto findStudentAttributeFetch1ById(@PathVariable Integer id) {
        return oneToManyService.findStudentAttributeFetch1ById(id);
    }

    @GetMapping(value = "student/fetch1")
    public List<StudentAssociationBooksDto> findStudentAttributeFetch1() {
        return oneToManyService.findStudentAttributeFetch1();
    }

    //fetch第二种 Fetch.LAZY
    @GetMapping(value = "student/fetch2/{id:\\d+}")
    public StudentAssociationBooksDto findStudentAttributeFetch2ById(@PathVariable Integer id) {
        return oneToManyService.findStudentAttributeFetch2ById(id);
    }

    @GetMapping(value = "student/fetch2")
    public List<StudentAssociationBooksDto> findStudentAttributeFetch2() {
        return oneToManyService.findStudentAttributeFetch2();
    }

    //orphanRemoval第一种 orphanRemoval=false
    @DeleteMapping(value = "student/orphanRemoval1/{id:\\d+}")
    public boolean deleteStudentAttributeOrphanRemoval1ById(@PathVariable Integer id) {
        return oneToManyService.deleteStudentAttributeOrphanRemoval1ById(id);
    }


    //orphanRemoval第二种 orphanRemoval=true
    @DeleteMapping(value = "student/orphanRemoval2/{id:\\d+}")
    public boolean deleteStudentAttributeOrphanRemoval2ById(@PathVariable Integer id) {
        return oneToManyService.deleteStudentAttributeOrphanRemoval2ById(id);
    }
}
