package com.gcu.site.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.site.business.ElementBusinessInterface;
import com.gcu.site.business.PurchaseBusinessInterface;
import com.gcu.site.model.ElementModel;
import com.gcu.site.model.PurchaseModel;

@Controller
public class transactionController {

    @Autowired 
    ElementBusinessInterface elementService;

    @Autowired
    PurchaseBusinessInterface purchaseService;

    @PostMapping("/table/secret/doAddElement")
    public String createElement(@Valid ElementModel elementModel, BindingResult bindingResult, Model model)
    {

        elementService.addElement(elementModel);
        return "table";
    }

    @PostMapping("/doAddPurchase")
    public String doPurchase(@Valid PurchaseModel purchaseModel, BindingResult bindingResult,Model model)
    {
        if( bindingResult.hasErrors())
        {
            return "index";
        }

        System.out.print("purchaseModel: " + purchaseModel.getPurchaser() + ", " + purchaseModel.getItemID() + ", " + purchaseModel.getQuantity());
        purchaseService.addPurchase(purchaseModel);
        return "purchase";
    }
}
