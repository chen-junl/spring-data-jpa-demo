package com.example.demotest.service;

import cn.hutool.core.bean.BeanUtil;
import com.example.demotest.dto.association.BookAssociationStudentDto;
import com.example.demotest.entity.not_found.StudentBooksNotFoundManyToOneCommonEntity;
import com.example.demotest.entity.not_found.StudentBooksNotFoundManyToOneEntity;
import com.example.demotest.repository.not_found.StudentBooksNotFoundManyToOneEntityCommonRepository;
import com.example.demotest.repository.not_found.StudentBooksNotFoundManyToOneEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenjunl
 * @description
 * @date 2023/6/5
 */
@Service
public class NotFoundService {


    @Autowired
    private StudentBooksNotFoundManyToOneEntityCommonRepository studentBooksNotFoundManyToOneEntityCommonRepository;
    @Autowired
    private StudentBooksNotFoundManyToOneEntityRepository studentBooksNotFoundManyToOneEntityRepository;


    public BookAssociationStudentDto findBookCommonById(Integer id) {
        StudentBooksNotFoundManyToOneCommonEntity entity = studentBooksNotFoundManyToOneEntityCommonRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, BookAssociationStudentDto.class);
    }


    public BookAssociationStudentDto findBookTypeById(Integer id) {
        StudentBooksNotFoundManyToOneEntity entity = studentBooksNotFoundManyToOneEntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, BookAssociationStudentDto.class);
    }

}
