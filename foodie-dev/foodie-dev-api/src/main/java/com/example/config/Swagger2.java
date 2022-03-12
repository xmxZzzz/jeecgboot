package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

    //官方访问地址：swagger-ui.html
    // 本地访问路径：http://localhost:8088/swagger-ui.html
    // swagger-bootstrap-ui的访问路径：http://localhost:8088/doc.html

    //Swagger2核心配置 docket
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)          //指定api类型为Swagger2
                .apiInfo(apiInfo())                         // 用于指定api文档信息
                .select().apis(RequestHandlerSelectors.basePackage("com.example.controller"))   //指定需要扫描的controller路径
                .paths(PathSelectors.any())                 // 所有controller
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("天天吃货 电商平台接口API")              //文档页标题
                .contact(new Contact("guoyy7",
                        "https://www.imooc.com",
                        "abc@imooc.com"))             // 联系人信息
                .description("专为天天吃货提供的api文档")      // 描述信息
                .version("1.0.1")                           // 版本号
                .termsOfServiceUrl("https://www.imooc.com") //网站地址
                .build();
    }
}
