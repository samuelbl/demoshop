package com.samuelapp.demoshop.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerController {

    @RequestMapping("/")
    public String index() {
        return "redirect:swagger-ui/index.html";
    }
}