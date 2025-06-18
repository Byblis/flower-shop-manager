
package com.example.flowershopmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.flowershopmanager.entity") // ★ 追加
@EnableJpaRepositories(basePackages = "com.example.flowershopmanager.repository") // ★ 追加
public class FlowerShopManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowerShopManagerApplication.class, args);
    }

    @Bean
    public CommandLineRunner checkBeans(ApplicationContext ctx) {
        return args -> {
            System.out.println("========= BEANS =========");
            for (String name : ctx.getBeanDefinitionNames()) {
                System.out.println(name);
            }
        };
    }
}


