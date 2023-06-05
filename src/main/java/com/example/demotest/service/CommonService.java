package com.example.demotest.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.example.demotest.dto.StudentDto;
import com.example.demotest.entity.StudentEntity;
import com.example.demotest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenjunl
 * @description
 * @date 2023/4/23
 */
@Service
public class CommonService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentDto findById(Integer id) {
        StudentEntity entity = studentRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentDto.class);
    }

    public StudentDto insertStudent(StudentEntity entity) {
        return BeanUtil.copyProperties(studentRepository.save(entity), StudentDto.class);
    }

    public StudentDto updateStudent(Integer id) {
        StudentEntity entity = studentRepository.findById(id).orElse(new StudentEntity());
        entity.setTitle("我改变了->" + DateUtil.now());
        return BeanUtil.copyProperties(studentRepository.save(entity), StudentDto.class);
    }

    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

}
