package com.example.demotest.service;

import cn.hutool.core.date.DateUtil;
import com.example.demotest.entity.TeacherEntity;
import com.example.demotest.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenjunl
 * @description
 * @date 2023/4/23
 */
@Service
public class VersionService {

    @Autowired
    private TeacherRepository teacherRepository;


    public TeacherEntity updateTeacher(Integer id) {
        TeacherEntity teacherEntity = teacherRepository.findById(id).orElse(new TeacherEntity());
        teacherEntity.setModifier(DateUtil.now());
        //程序断点,去数据库中更新这个记录的version字段
        return teacherRepository.save(teacherEntity);
    }
}
