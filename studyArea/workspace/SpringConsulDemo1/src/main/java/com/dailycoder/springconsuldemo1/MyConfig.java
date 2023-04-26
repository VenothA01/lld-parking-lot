package com.dailycoder.springconsuldemo1;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my")
@Data
public class MyConfig {

    private String userName;
    private String password;
}
