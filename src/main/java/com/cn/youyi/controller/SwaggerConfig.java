package com.cn.youyi.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableWebMvc
@EnableSwagger2 //开启了Swagger2
public class SwaggerConfig {

    //配置了Swagger的Docket实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    //配置Swagger文档信息=ApiInfo
    private ApiInfo apiInfo(){
        Contact contact = new Contact("刘洋铭", "https://www.cnblogs.com/liuyangming/", "1792099653@qq.com");

        return new ApiInfo("游易 Swagger2 API文档",
                "游易接口1.0版本",
                "1.0",
                "https://www.cnblogs.com/liuyangming/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
