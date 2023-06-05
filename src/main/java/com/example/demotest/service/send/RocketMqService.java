package com.example.demotest.service.send;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author chenjunl
 * @description
 * @date 2023/4/28
 */
@Service
@Slf4j
public class RocketMqService {


    public boolean sendMessage(Object o, String method) {
        log.info("经过发送消息方法,method:{},body:{}", method, JSONUtil.toJsonStr(o));
        ThreadUtil.sleep(500);
        log.info("发送消息完毕");
        return true;
    }
}
