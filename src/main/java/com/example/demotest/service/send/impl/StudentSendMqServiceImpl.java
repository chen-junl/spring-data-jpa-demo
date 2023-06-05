package com.example.demotest.service.send.impl;

import com.example.demotest.base.BaseSendMqService;
import com.example.demotest.entity.StudentEntity;
import com.example.demotest.service.send.RocketMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenjunl
 * @description
 * @date 2023/4/28
 */
@Component
public class StudentSendMqServiceImpl implements BaseSendMqService<StudentEntity> {

    @Autowired
    private RocketMqService rocketMqService;

    @Override
    public boolean sendMq(StudentEntity entity, String method) {
        return rocketMqService.sendMessage(entity, method);
    }
}
