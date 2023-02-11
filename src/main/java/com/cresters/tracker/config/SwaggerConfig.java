package com.cresters.tracker.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import java.util.Collections;

@Configuration
@EnableWebMvc
//@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("Cresters Hub")
//                .select()
////        RequestHandlerSelectors.any()
//                .apis(RequestHandlerSelectors.basePackage("com.cresters.tracker.controllers"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//    private ApiInfo apiInfo() {
//        return new ApiInfo("Tracker Service", "API Documentation of Crester Tech Hub v1.0", "1.0",
//                "Terms of service", new Contact("CresterHub", "https://Seek.org", "crestershub@gmail.com"),
//                "License of API", "License", Collections.emptyList());
//    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }
}
