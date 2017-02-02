package com.lisnykov.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by pasha on 2/1/17.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(("com.lisnykov"))
//@EnableJpaRepositories(("com.lisnykov"))
//@EntityScan(("com.lisnykov"))
public class SpringBootApplication extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(SpringBootApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

}
