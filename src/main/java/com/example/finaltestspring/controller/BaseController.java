package com.example.finaltestspring.controller;

import com.example.finaltestspring.config.properties.CommonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
    @Autowired
    protected CommonProperties commonProperties;
}
