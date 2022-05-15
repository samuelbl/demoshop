package com.samuelapp.demoshop.config;

import com.samuelapp.demoshop.model.User;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.samuelapp.demoshop.controler"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo()).ignoredParameterTypes(User.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("DemoShop API")
                .description("Sample Crud Spring with Postgres")
                .contact(new Contact("Samuel Bristot Loli", "https://github.com/samuelbl/demoshop", "bristot@gmail.com"))
                .version("1.0").build();
    }
}
