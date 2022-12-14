package com.example.demo.config;

import com.example.demo.config.annotation.TokenToAdminUser;
import com.example.demo.entity.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.api"))
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(TokenToAdminUser.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("宠物爱好者Swagger")
                .description("宠物爱好者Swagger")
                .version("1.0")
                .build();
    }
}