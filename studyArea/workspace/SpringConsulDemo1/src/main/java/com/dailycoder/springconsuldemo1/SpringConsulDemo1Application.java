package com.dailycoder.springconsuldemo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(value = MyConfig.class)
public class SpringConsulDemo1Application {

    @Autowired
    MyConfig myConfig;

    @GetMapping("/getConfigData")
    public MyConfig getConfig(){
        return myConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringConsulDemo1Application.class, args);
    }

}
