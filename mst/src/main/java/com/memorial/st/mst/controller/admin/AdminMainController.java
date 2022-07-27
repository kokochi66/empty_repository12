package com.memorial.st.mst.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(value = "/admin")
public class AdminMainController {


    @GetMapping("")
    public String adminHome() {
        return "admin/home";
    }
}
