package com.example.demotest.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.example.demotest.dto.secondary_table.StudentAndDetailSecondaryTableDto;
import com.example.demotest.entity.secondary_table.StudentAndDetailSecondaryTableEntity;
import com.example.demotest.repository.secondary_table.StudentAndDetailSecondaryTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenjunl
 * @description
 * @date 2023/4/23
 */
@Service
public class SecondTableService {

    @Autowired
    private StudentAndDetailSecondaryTableRepository studentAndDetailSecondaryTableRepository;

    public StudentAndDetailSecondaryTableDto findStudentDetailById(Integer id) {
        StudentAndDetailSecondaryTableEntity entity = studentAndDetailSecondaryTableRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAndDetailSecondaryTableDto.class);
    }

    public StudentAndDetailSecondaryTableDto insertStudentDetail(StudentAndDetailSecondaryTableEntity entity) {
        return BeanUtil.copyProperties(studentAndDetailSecondaryTableRepository.save(entity), StudentAndDetailSecondaryTableDto.class);
    }

    public StudentAndDetailSecondaryTableDto updateStudentDetailById(Integer id) {
        StudentAndDetailSecondaryTableEntity entity = studentAndDetailSecondaryTableRepository.findById(id).orElse(new StudentAndDetailSecondaryTableEntity());
        entity.setTitle("我改变了->" + DateUtil.now());
        return BeanUtil.copyProperties(studentAndDetailSecondaryTableRepository.save(entity), StudentAndDetailSecondaryTableDto.class);
    }

}
