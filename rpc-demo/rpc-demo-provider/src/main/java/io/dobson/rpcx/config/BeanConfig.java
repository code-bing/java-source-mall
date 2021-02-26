package io.dobson.rpcx.config;

import io.dobson.rpcx.api.StudentService;
import io.dobson.rpcx.impl.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean("io.dobson.rpcx.api.StudentService")
    public StudentService studentService(){
        return new StudentServiceImpl();
    };
}
