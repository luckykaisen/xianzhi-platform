package com.xianzhi.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@MapperScan("com.xianzhi.platform.webapp.mapper")
@EnableJpaRepositories
@SpringBootApplication
public class XianzhiPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(XianzhiPlatformApplication.class, args);
    }

}
