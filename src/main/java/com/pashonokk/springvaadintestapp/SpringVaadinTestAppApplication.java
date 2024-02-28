package com.pashonokk.springvaadintestapp;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Theme("custom")
public class SpringVaadinTestAppApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(SpringVaadinTestAppApplication.class, args);
    }

    @Bean
    public RestTemplate RestTemplate() {
        return new RestTemplate();
    }
}
