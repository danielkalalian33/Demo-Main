package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/history")
public class HistoryController {

    @GetMapping("/getAll")
    public String getAll() {

        return "";
    }
}
