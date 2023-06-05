package com.example.demotest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author chenjunl
 * @description
 * @date 2023/5/15
 */
@Configuration
public class ScheduledConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        executor.setCorePoolSize(5);
        //设置最大线程数
        executor.setMaxPoolSize(10);
        //设置任务队列容量
        executor.setQueueCapacity(10);
        //设置线程活跃时间（秒）
        //executor.setKeepAliveSeconds(3600);
        //设置默认线程名称(线程前缀名称，有助于区分不同线程池之间的线程比如：taskExecutor-thread-)
        executor.setThreadNamePrefix("taskExecutor-thread-");
        //设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //设置允许核心线程超时，默认是false
        executor.setAllowCoreThreadTimeOut(false);
        return executor;
    }
}
