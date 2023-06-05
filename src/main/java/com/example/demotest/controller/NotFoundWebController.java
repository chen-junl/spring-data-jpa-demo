package com.example.demotest.controller;

import com.example.demotest.dto.association.BookAssociationStudentDto;
import com.example.demotest.service.NotFoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenjunl
 * @description
 * @date 2023/6/5
 */
@Controller
@ResponseBody
@RequestMapping(value = "not-found")
public class NotFoundWebController {

    @Autowired
    private NotFoundService notFoundService;

    //不指定
    @GetMapping(value = "book/common/{id:\\d+}")
    public BookAssociationStudentDto findBookById(@PathVariable Integer id) {
        return notFoundService.findBookCommonById(id);
    }

    //action=IGNORE
    @GetMapping(value = "book/type/{id:\\d+}")
    public BookAssociationStudentDto findBookTypeById(@PathVariable Integer id) {
        return notFoundService.findBookTypeById(id);
    }

}
