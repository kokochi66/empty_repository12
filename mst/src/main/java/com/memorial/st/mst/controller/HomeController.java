package com.memorial.st.mst.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class HomeController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpServletResponse response, HttpServletRequest request) {
        log.info("/ - main index");
        return "index";
    }

    @GetMapping(value = "/api/hello")
    public String hello() {
        return "hello kokochikochi";
    }
}
