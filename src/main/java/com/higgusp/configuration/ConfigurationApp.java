package com.higgusp.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//khai báo đây là một class để config
@Configuration
//bật webmvc
@EnableWebMvc
//cam bean trong thư mục chỉ định. tất cả các service..vv..
@ComponentScan(basePackages = "com.higgusp")
public class ConfigurationApp {
}
