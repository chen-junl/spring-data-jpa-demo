package com.example.demotest.config;

import com.example.demotest.base.impl.BaseRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author chenjunl
 * @description
 * @date 2023/6/15
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.example.demotest.repository", repositoryBaseClass = BaseRepositoryImpl.class)
public class BaseRepositoryConfig {
}
