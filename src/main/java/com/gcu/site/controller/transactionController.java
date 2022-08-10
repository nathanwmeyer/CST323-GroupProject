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

/* navigationController:
 * This class manages actions in the application that involve adding new elements or purchases to the application's database
 */
@Controller
public class transactionController {

    Logger logger = LogManager.getLogger(transactionController.class);
    
    @Autowired 
    ElementBusinessInterface elementService;

    @Autowired
    PurchaseBusinessInterface purchaseService;

    /* createElement:
     * takes information from the form in the addElement page and adds it to the database using ElementBusinessService
     * 
     * if the form is incomplete or there are errors in the form, it returns to the index page instead without adding an element to the database
     */
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

    /* doPurchase:
     * takes information from the form in the purchase page and adds it to the database using PurchaseBusinessService
     * 
     * if the form is incomplete or there are errors in the form, it returns to the index page instead without adding a purchase to the database
     */
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
