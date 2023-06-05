package com.example.demotest.controller;

import com.example.demotest.dto.association.DetailAssociationStudentDto;
import com.example.demotest.dto.association.StudentAssociationDetailDto;
import com.example.demotest.service.OneToOneService;
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
@RequestMapping(value = "one-to-one")
public class OneToOneWebController {

    @Autowired
    private OneToOneService oneToOneService;

    //单向级联关联
    @GetMapping(value = "student/type1/{id:\\d+}")
    public StudentAssociationDetailDto findStudent1ById(@PathVariable Integer id) {
        return oneToOneService.findStudent1ById(id);
    }

    @GetMapping(value = "detail/type1/{id:\\d+}")
    public DetailAssociationStudentDto findStudentDetail1ById(@PathVariable Integer id) {
        return oneToOneService.findStudentDetail1ById(id);
    }


    //双向级联关联
    @GetMapping(value = "student/type2/{id:\\d+}")
    public StudentAssociationDetailDto findStudent2ById(@PathVariable Integer id) {
        return oneToOneService.findStudent2ById(id);
    }

    @GetMapping(value = "detail/type2/{id:\\d+}")
    public DetailAssociationStudentDto findStudentDetail2ById(@PathVariable Integer id) {
        return oneToOneService.findStudentDetail2ById(id);
    }

    //cascade第0种类型什么都不加
    @GetMapping(value = "detail/cascade0/{id:\\d+}")
    public DetailAssociationStudentDto findStudentDetailAttributeCascade0ById(@PathVariable Integer id) {
        return oneToOneService.findStudentDetailAttributeCascade0ById(id);
    }

    @PostMapping(value = "detail/cascade0")
    public DetailAssociationStudentDto insertStudentDetailAttributeCascade0ById(@RequestBody DetailAssociationStudentDto dto) {
        return oneToOneService.insertStudentDetailAttributeCascade0ById(dto);
    }

    @PutMapping(value = "detail/cascade0/{id:\\d+}")
    public DetailAssociationStudentDto updateStudentDetailAttributeCascade0ById(@PathVariable Integer id, @RequestBody DetailAssociationStudentDto dto) {
        return oneToOneService.updateStudentDetailAttributeCascade0ById(id, dto);
    }

    @DeleteMapping(value = "detail/cascade0/{id:\\d+}")
    public boolean deleteStudentDetailAttributeCascade0ById(@PathVariable Integer id) {
        return oneToOneService.deleteStudentDetailAttributeCascade0ById(id);
    }


    //cascade第一种类型 CascadeType.ALL
    @GetMapping(value = "detail/cascade1/{id:\\d+}")
    public DetailAssociationStudentDto findStudentDetailAttributeCascade1ById(@PathVariable Integer id) {
        return oneToOneService.findStudentDetailAttributeCascade1ById(id);
    }

    @PostMapping(value = "detail/cascade1")
    public DetailAssociationStudentDto insertStudentDetailAttributeCascade1ById(@RequestBody DetailAssociationStudentDto dto) {
        return oneToOneService.insertStudentDetailAttributeCascade1ById(dto);
    }

    @PutMapping(value = "detail/cascade1/{id:\\d+}")
    public DetailAssociationStudentDto updateStudentDetailAttributeCascade1ById(@PathVariable Integer id, @RequestBody DetailAssociationStudentDto dto) {
        return oneToOneService.updateStudentDetailAttributeCascade1ById(id, dto);
    }

    @DeleteMapping(value = "detail/cascade1/{id:\\d+}")
    public boolean deleteStudentDetailAttributeCascade1ById(@PathVariable Integer id) {
        return oneToOneService.deleteStudentDetailAttributeCascade1ById(id);
    }

    //cascade第二种类型 CascadeType.PERSIST
    @GetMapping(value = "detail/cascade2/{id:\\d+}")
    public DetailAssociationStudentDto findStudentDetailAttributeCascade2ById(@PathVariable Integer id) {
        return oneToOneService.findStudentDetailAttributeCascade2ById(id);
    }

    @PostMapping(value = "detail/cascade2")
    public DetailAssociationStudentDto insertStudentDetailAttributeCascade2ById(@RequestBody DetailAssociationStudentDto dto) {
        return oneToOneService.insertStudentDetailAttributeCascade2ById(dto);
    }

    @PutMapping(value = "detail/cascade2/{id:\\d+}")
    public DetailAssociationStudentDto updateStudentDetailAttributeCascade2ById(@PathVariable Integer id, @RequestBody DetailAssociationStudentDto dto) {
        return oneToOneService.updateStudentDetailAttributeCascade2ById(id, dto);
    }

    @DeleteMapping(value = "detail/cascade2/{id:\\d+}")
    public boolean deleteStudentDetailAttributeCascade2ById(@PathVariable Integer id) {
        return oneToOneService.deleteStudentDetailAttributeCascade2ById(id);
    }

    //cascade第三种类型 CascadeType.MERGE
    @GetMapping(value = "detail/cascade3/{id:\\d+}")
    public DetailAssociationStudentDto findStudentDetailAttributeCascade3ById(@PathVariable Integer id) {
        return oneToOneService.findStudentDetailAttributeCascade3ById(id);
    }

    @PostMapping(value = "detail/cascade3")
    public DetailAssociationStudentDto insertStudentDetailAttributeCascade3ById(@RequestBody DetailAssociationStudentDto dto) {
        return oneToOneService.insertStudentDetailAttributeCascade3ById(dto);
    }

    @PutMapping(value = "detail/cascade3/{id:\\d+}")
    public DetailAssociationStudentDto updateStudentDetailAttributeCascade3ById(@PathVariable Integer id, @RequestBody DetailAssociationStudentDto dto) {
        return oneToOneService.updateStudentDetailAttributeCascade3ById(id, dto);
    }

    @DeleteMapping(value = "detail/cascade3/{id:\\d+}")
    public boolean deleteStudentDetailAttributeCascade3ById(@PathVariable Integer id) {
        return oneToOneService.deleteStudentDetailAttributeCascade3ById(id);
    }

    //cascade第四种类型 CascadeType.REMOVE
    @GetMapping(value = "detail/cascade4/{id:\\d+}")
    public DetailAssociationStudentDto findStudentDetailAttributeCascade4ById(@PathVariable Integer id) {
        return oneToOneService.findStudentDetailAttributeCascade4ById(id);
    }

    @PostMapping(value = "detail/cascade4")
    public DetailAssociationStudentDto insertStudentDetailAttributeCascade4ById(@RequestBody DetailAssociationStudentDto dto) {
        return oneToOneService.insertStudentDetailAttributeCascade4ById(dto);
    }

    @PutMapping(value = "detail/cascade4/{id:\\d+}")
    public DetailAssociationStudentDto updateStudentDetailAttributeCascade4ById(@PathVariable Integer id, @RequestBody DetailAssociationStudentDto dto) {
        return oneToOneService.updateStudentDetailAttributeCascade4ById(id, dto);
    }

    @DeleteMapping(value = "detail/cascade4/{id:\\d+}")
    public boolean deleteStudentDetailAttributeCascade4ById(@PathVariable Integer id) {
        return oneToOneService.deleteStudentDetailAttributeCascade4ById(id);
    }


    //cascade第五种类型 CascadeType.REFRESH
    @GetMapping(value = "detail/cascade5/{id:\\d+}")
    public DetailAssociationStudentDto findStudentDetailAttributeCascade5ById(@PathVariable Integer id) {
        return oneToOneService.findStudentDetailAttributeCascade5ById(id);
    }

    @PostMapping(value = "detail/cascade5")
    public DetailAssociationStudentDto insertStudentDetailAttributeCascade5ById(@RequestBody DetailAssociationStudentDto dto) {
        return oneToOneService.insertStudentDetailAttributeCascade5ById(dto);
    }

    @PutMapping(value = "detail/cascade5/{id:\\d+}")
    public DetailAssociationStudentDto updateStudentDetailAttributeCascade5ById(@PathVariable Integer id, @RequestBody DetailAssociationStudentDto dto) {
        return oneToOneService.updateStudentDetailAttributeCascade5ById(id, dto);
    }

    @DeleteMapping(value = "detail/cascade5/{id:\\d+}")
    public boolean deleteStudentDetailAttributeCascade5ById(@PathVariable Integer id) {
        return oneToOneService.deleteStudentDetailAttributeCascade5ById(id);
    }


    //cascade第六种类型 CascadeType.DETACH
    @GetMapping(value = "detail/cascade6/{id:\\d+}")
    public DetailAssociationStudentDto findStudentDetailAttributeCascade6ById(@PathVariable Integer id) {
        return oneToOneService.findStudentDetailAttributeCascade6ById(id);
    }

    @PostMapping(value = "detail/cascade6")
    public DetailAssociationStudentDto insertStudentDetailAttributeCascade6ById(@RequestBody DetailAssociationStudentDto dto) {
        return oneToOneService.insertStudentDetailAttributeCascade6ById(dto);
    }

    @PutMapping(value = "detail/cascade6/{id:\\d+}")
    public DetailAssociationStudentDto updateStudentDetailAttributeCascade6ById(@PathVariable Integer id, @RequestBody DetailAssociationStudentDto dto) {
        return oneToOneService.updateStudentDetailAttributeCascade6ById(id, dto);
    }

    @DeleteMapping(value = "detail/cascade6/{id:\\d+}")
    public boolean deleteStudentDetailAttributeCascade6ById(@PathVariable Integer id) {
        return oneToOneService.deleteStudentDetailAttributeCascade6ById(id);
    }


    //fetch第一种 Fetch.EAGER
    @GetMapping(value = "detail/fetch1/{id:\\d+}")
    public DetailAssociationStudentDto findStudentDetailAttributeFetch1ById(@PathVariable Integer id) {
        return oneToOneService.findStudentDetailAttributeFetch1ById(id);
    }

    @GetMapping(value = "detail/fetch1")
    public List<DetailAssociationStudentDto> findStudentDetailAttributeFetch1() {
        return oneToOneService.findStudentDetailAttributeFetch1();
    }

    //fetch第二种 Fetch.LAZY
    @GetMapping(value = "detail/fetch2/{id:\\d+}")
    public DetailAssociationStudentDto findStudentDetailAttributeFetch2ById(@PathVariable Integer id) {
        return oneToOneService.findStudentDetailAttributeFetch2ById(id);
    }

    @GetMapping(value = "detail/fetch2")
    public List<DetailAssociationStudentDto> findStudentDetailAttributeFetch2() {
        return oneToOneService.findStudentDetailAttributeFetch2();
    }

    //optional第一种  optional=true
    @GetMapping(value = "detail/optional1/{id:\\d+}")
    public DetailAssociationStudentDto findStudentDetailAttributeOptional1ById(@PathVariable Integer id) {
        return oneToOneService.findStudentDetailAttributeOptional1ById(id);
    }

    @PostMapping(value = "detail/optional1")
    public DetailAssociationStudentDto insertStudentDetailAttributeOptional1ById(@RequestBody DetailAssociationStudentDto dto) {
        return oneToOneService.insertStudentDetailAttributeOptional1ById(dto);
    }


    //optional第二种 optional=false
    @GetMapping(value = "detail/optional2/{id:\\d+}")
    public DetailAssociationStudentDto findStudentDetailAttributeOptional2ById(@PathVariable Integer id) {
        return oneToOneService.findStudentDetailAttributeOptional2ById(id);
    }

    @PostMapping(value = "detail/optional2")
    public DetailAssociationStudentDto insertStudentDetailAttributeOptional2ById(@RequestBody DetailAssociationStudentDto dto) {
        return oneToOneService.insertStudentDetailAttributeOptional2ById(dto);
    }


    //orphanRemoval第一种 orphanRemoval=false
    @DeleteMapping(value = "detail/orphanRemoval1/{id:\\d+}")
    public boolean deleteStudentDetailAttributeOrphanRemoval1ById(@PathVariable Integer id) {
        return oneToOneService.deleteStudentDetailAttributeOrphanRemoval1ById(id);
    }


    //orphanRemoval第二种 orphanRemoval=true
    @DeleteMapping(value = "detail/orphanRemoval2/{id:\\d+}")
    public boolean deleteStudentDetailAttributeOrphanRemoval2ById(@PathVariable Integer id) {
        return oneToOneService.deleteStudentDetailAttributeOrphanRemoval2ById(id);
    }
}
