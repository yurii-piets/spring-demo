package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class TextController {

    @RequestMapping(value = "/text", method = RequestMethod.GET)
    public @ResponseBody String text() {
        return "Hello world";
    }
}
