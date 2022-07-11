package com.board.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/")
    public String Home() {

        return "index";
    }
}
