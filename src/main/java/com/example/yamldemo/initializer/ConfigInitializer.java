package com.example.yamldemo.initializer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

@Slf4j
public class ConfigInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        try {
            Resource res = configurableApplicationContext.getResource("classpath:/server.yml");
            YamlPropertySourceLoader propertySourceLoader = new YamlPropertySourceLoader();
            List<PropertySource<?>> propertySource = propertySourceLoader.load("server",res);
            configurableApplicationContext.getEnvironment().getPropertySources().addFirst(propertySource.get(0));
            log.info("YAML SOURCE LOADED : {}",res.getFilename());
        } catch (IOException e) {
            log.info("IO-EXCEPTION : {}",e.getCause());
        }
    }
}
