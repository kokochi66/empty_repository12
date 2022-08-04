package com.memorial.st.mst.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(value = "/layout/test")
public class TestController {

    @GetMapping("")
    public String layoutTest() {
        return "layoutTest/content";
    }
}
