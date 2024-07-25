package com.soft.app17.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PropertySources({
        @PropertySource("classpath:user.properties"),
        @PropertySource("classpath:/config/user.properties"),
        @PropertySource("file:./config/user.properties"),
        @PropertySource("file:./user.properties")
}
)
@RestController
public class UserController {
    @Autowired
    private Environment environment;
    @RequestMapping("/user")
    public String getUserDetails(){
        String data = "<h1>User[";
        data = data + environment.getProperty("user.name")+",";
        data = data + environment.getProperty("user.qual")+",";
        data = data + environment.getProperty("user.email")+",";
        data = data + environment.getProperty("user.mobile")+"]</h>";
        return data;
    }
}


