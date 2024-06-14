package ru.gb.Spring_HW12_Tests_Aspects_Integrations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.gb.Spring_HW12_Tests_Aspects_Integrations.aspect.AspectChanger;

@Configuration
@ComponentScan(basePackages = "ru.gb.Spring_HW12_Tests_Aspects_Integrations")
@EnableAspectJAutoProxy
public class Config {
    @Bean
    public AspectChanger getChange() {
        return new AspectChanger();
    }
}