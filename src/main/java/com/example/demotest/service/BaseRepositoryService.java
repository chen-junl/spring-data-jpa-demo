package com.example.demotest.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.example.demotest.dto.StudentDto;
import com.example.demotest.entity.StudentEntity;
import com.example.demotest.entity.TeacherEntity;
import com.example.demotest.repository.StudentRepository;
import com.example.demotest.repository.TeacherRepository;
import com.example.demotest.repository.base.StudentBaseRepository;
import com.example.demotest.repository.base.TeacherBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @author chenjunl
 * @description
 * @date 2023/4/23
 */
@Service
public class BaseRepositoryService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentBaseRepository studentBaseRepository;
    @Autowired
    private TeacherBaseRepository teacherBaseRepository;

    public StudentDto updateStudentByIdMq(Integer id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElse(new StudentEntity());
        studentEntity.setGmtModified(new Timestamp(System.currentTimeMillis()));
        studentEntity.setTitle("我改变了->" + DateUtil.now());
        studentRepository.save(studentEntity);

        //正确的发送消息
        StudentEntity studentEntity1 = studentRepository.findById(id + 1).orElse(new StudentEntity());
        studentEntity1.setGmtModified(new Timestamp(System.currentTimeMillis()));
        studentEntity.setTitle("我改变了->" + DateUtil.now());
        studentBaseRepository.saveWithMq(studentEntity1);

        TeacherEntity teacherEntity = teacherRepository.findById(id).orElse(new TeacherEntity());
        teacherEntity.setGmtModified(new Timestamp(System.currentTimeMillis()));
        studentEntity.setTitle("我改变了->" + DateUtil.now());
        teacherRepository.save(teacherEntity);

        //如果没有没有实现类的请款下调用
        TeacherEntity teacherEntity1 = teacherBaseRepository.findById(id + 1).orElse(new TeacherEntity());
        teacherEntity1.setGmtModified(new Timestamp(System.currentTimeMillis()));
        studentEntity.setTitle("我改变了->" + DateUtil.now());
        teacherBaseRepository.saveWithMq(teacherEntity1);

        return BeanUtil.copyProperties(studentEntity, StudentDto.class);
    }
}
