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

import com.gcu.site.business.ElementBusinessInterface;
import com.gcu.site.business.PurchaseBusinessInterface;
import com.gcu.site.model.ElementModel;
import com.gcu.site.model.PurchaseModel;

@Controller
public class navigationController {
    @Autowired 
    ElementBusinessInterface elementService;

    @Autowired
    PurchaseBusinessInterface purchaseService;

    @GetMapping("/")
    public String accessHome(Model model)
    {
        model.addAttribute("title", "Home");
        
        return "index";
    }

    @GetMapping("/table")
    public String accessTable(Model model)
    {
        model.addAttribute("title", "Home");
        model.addAttribute("elements", elementService.getElement());
        return "table";
    }

    @GetMapping("/table/secret/addElement")
    public String createElement(Model model)
    {
        model.addAttribute("title", "Home");
        model.addAttribute("elements", elementService.getElement());
        model.addAttribute("elementModel", new ElementModel());
        return "addNewElement";
    }

    @GetMapping("/about")
    public String accessAbout(Model model)
    {
        model.addAttribute("title", "Home");
        return "about";
    }
    
    @GetMapping("/purchase")
    public String purchase(Model model)
    {
        model.addAttribute("title", "Home");
        model.addAttribute("purchases", purchaseService.getPurchase());
        model.addAttribute("elements", elementService.getElement());
        model.addAttribute("purchaseModel", new PurchaseModel());
        return "purchase";
    }
}
