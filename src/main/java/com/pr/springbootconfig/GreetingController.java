package com.pr.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    // injects the value of the property into the variable
    @Value("${my.greeting: default value}")
    private String greetingMessage;

    @Value("some static message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

    @Autowired
    private DbSettings dbSettings;

    @Value("#{${dbValues}}")
    private Map<String, String> dbValues;

    public GreetingController() {
    }

    @GetMapping("/greeting")
    public String greeting() {
        return greetingMessage + staticMessage + listValues + dbValues;
    }

    @GetMapping("/dbgreeting")
    public String greeting2() {
        return dbSettings.getConnection() + dbSettings.getHost();
    }
}
