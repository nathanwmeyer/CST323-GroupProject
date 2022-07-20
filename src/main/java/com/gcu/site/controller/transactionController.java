package com.gcu.site.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class transactionController {
    @GetMapping("/")
    public String accessHome(Model model)
    {
        model.addAttribute("title", "Home");
        
        return "index";
    }

    @GetMapping("/table/secret/doAddElement")
    public String createElement(Model model)
    {
        return "table";
    }
}
