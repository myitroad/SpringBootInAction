package com.vash.boot_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用程序的启动引导类
 * bootstrap class
 * <p>
 * 启动
 * <p>
 * 引导配置
 */
@SpringBootApplication
@MapperScan("com.vash.boot_demo.dao")
public class ReadingListApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadingListApplication.class, args);
    }

}
