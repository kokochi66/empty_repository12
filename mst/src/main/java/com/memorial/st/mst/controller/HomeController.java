package com.memorial.st.mst.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpServletResponse response, HttpServletRequest request) throws IOException {
        log.info("/ - main index :: path = " + resourceLoader.getResource("classpath:static").getURI().getPath());

        return "index";
    }

    @GetMapping(value = "/api/hello")
    public String hello() {
        return "hello kokochikochi";
    }
}
