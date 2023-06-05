package com.example.demotest.service;

import cn.hutool.core.bean.BeanUtil;
import com.example.demotest.dto.type_json.StudentDetailTypeJsonDto;
import com.example.demotest.entity.type_json.StudentDetailTypeJsonEntity;
import com.example.demotest.repository.type_json.StudentDetailTypeJsonEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenjunl
 * @description
 * @date 2023/4/23
 */
@Service
public class TypeJsonService {

    @Autowired
    private StudentDetailTypeJsonEntityRepository studentDetailTypeJsonEntityRepository;


    public StudentDetailTypeJsonDto typeJsonFindById(Integer id) {
        StudentDetailTypeJsonEntity entity = studentDetailTypeJsonEntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentDetailTypeJsonDto.class);
    }
}
