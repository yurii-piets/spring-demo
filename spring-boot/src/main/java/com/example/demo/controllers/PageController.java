package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class PageController {

    public static final String PAGE_TEMPLATE = "html/page";

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String html() {
        return PAGE_TEMPLATE;
    }
}
