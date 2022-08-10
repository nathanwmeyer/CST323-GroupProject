package com.gcu.site.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.site.business.ElementBusinessInterface;
import com.gcu.site.business.PurchaseBusinessInterface;
import com.gcu.site.model.ElementModel;
import com.gcu.site.model.PurchaseModel;

/* navigationController:
 * This class manages navigation around the application, it does not handle actions in the application that involve adding new elements or purchases
 */
@Controller
public class navigationController {
    
    Logger logger = LogManager.getLogger(navigationController.class);

    @Autowired 
    ElementBusinessInterface elementService;

    @Autowired
    PurchaseBusinessInterface purchaseService;

    /* accessHome:
     * access the index page, the home page of the application
     */
    @GetMapping("/")
    public String accessHome(Model model)
    {
        logger.info("entering accessHome method");
        model.addAttribute("title", "Home");
        
        logger.info("exiting accessHome method");
        return "index";
    }

    /* accessTable:
     * access the table page, this page uses ElementBusinessService to retrieve a list of all elements in the database
     * which it then displays in a table
     */
    @GetMapping("/table")
    public String accessTable(Model model)
    {
        logger.info("entering accessTable method");
        model.addAttribute("title", "Home");
        model.addAttribute("elements", elementService.getElement());
        logger.info("exiting accessTable method");
        return "table";
    }

    /* createElement:
     * access the addElement page, which allows administrators to add new elements to the database by filling out a form
     */
    @GetMapping("/table/secret/addElement")
    public String createElement(Model model)
    {
        logger.info("entering addElement method");
        model.addAttribute("title", "Home");
        model.addAttribute("elements", elementService.getElement());
        model.addAttribute("elementModel", new ElementModel());
        logger.info("exiting addElement method");
        return "addNewElement";
    }

    /* accessAbout:
     * access the about page, which provides information about the application developers, as well as the technology and frameworks used for
     * designing and running the application
     */
    @GetMapping("/about")
    public String accessAbout(Model model)
    {
        logger.info("entering accessAbout method");
        model.addAttribute("title", "Home");
        logger.info("entering accessAbout method");
        return "about";
    }
    
    /* purchase:
     * access the purchase page, which allows users to purchase items in the business' inventory using a form
     */
    @GetMapping("/purchase")
    public String purchase(Model model)
    {
        logger.info("entering purchase method");
        model.addAttribute("title", "Home");
        model.addAttribute("purchases", purchaseService.getPurchase());
        model.addAttribute("elements", elementService.getElement());
        model.addAttribute("purchaseModel", new PurchaseModel());

        logger.info("exiting purchase method");
        return "purchase";
    }

    /* purchases:
     * access the purchases page, this table uses PurchaseBusinessService to retrieve a list of all purchases in the database
     * which it then displays in a table
     */
    @GetMapping("/purchase/secret/purchases")
    public String purchases(Model model)
    {
        logger.info("entering purchases method");
        model.addAttribute("title", "Purchases");
        
        model.addAttribute("purchases", purchaseService.getPurchase());

        logger.info("exiting purchases method");
        return "purchases";
    }
}
