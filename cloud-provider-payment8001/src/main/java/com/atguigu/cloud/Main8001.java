package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;//不要用Spring的MapperScan
@MapperScan("com.atguigu.cloud.mapper")//import tk.mybatis.spring.annotation.MapperScan
@SpringBootApplication
@RefreshScope //动态刷新
public class Main8001
{
    //main SpringApplication
    public static void main(String[] args) {
        SpringApplication.run(Main8001.class, args);
    }
}
