package com.gcu.site.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.site.business.ElementBusinessInterface;
import com.gcu.site.business.PurchaseBusinessInterface;
import com.gcu.site.model.ElementModel;
import com.gcu.site.model.PurchaseModel;

@Controller
public class transactionController {

    Logger logger = LogManager.getLogger(transactionController.class);
    
    @Autowired 
    ElementBusinessInterface elementService;

    @Autowired
    PurchaseBusinessInterface purchaseService;

    @PostMapping("/table/secret/doAddElement")
    public String createElement(@Valid ElementModel elementModel, BindingResult bindingResult, Model model)
    {
        logger.info("entering createElement method");

        if( bindingResult.hasErrors())
        {
            logger.error("bindingResult has errors, returning to index page");
            return "index";
        }
        elementService.addElement(elementModel);
        logger.info("exiting createElement method");
        return "addNewElement";
    }

    @PostMapping("/doAddPurchase")
    public String doPurchase(@Valid PurchaseModel purchaseModel, BindingResult bindingResult,Model model)
    {
        logger.info("entering doPurchase method");
        if( bindingResult.hasErrors())
        {
            logger.error("bindingResult has errors, returning to index page");
            return "index";
        }

        logger.info("Received form information: \npurchaseModel: " + purchaseModel.getPurchaser() + ", " + purchaseModel.getItemID() + ", " + purchaseModel.getQuantity());

        logger.info("exiting doPurchase method");
        purchaseService.addPurchase(purchaseModel);
        return "purchase";
    }
}
