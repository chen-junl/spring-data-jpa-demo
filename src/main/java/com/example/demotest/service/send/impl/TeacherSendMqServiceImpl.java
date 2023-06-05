package com.example.demotest.service.send.impl;

import com.example.demotest.entity.TeacherEntity;
import com.example.demotest.service.send.RocketMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenjunl
 * @description
 * @date 2023/4/28
 */
@Component
public class TeacherSendMqServiceImpl {

    @Autowired
    private RocketMqService rocketMqService;


    public boolean sendMq(TeacherEntity entity, String method) {
        return rocketMqService.sendMessage(entity, method);
    }
}
