package com.zh69183787;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class DcController {

    @Value("${user.name}")
    private String user;

    @GetMapping("/config")
    public String dc() {
        return user;
    }
}