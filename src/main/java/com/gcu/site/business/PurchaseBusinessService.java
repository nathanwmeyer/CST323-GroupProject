package com.gcu.site.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.site.data.ElementDataService;
import com.gcu.site.data.PurchaseDataService;
import com.gcu.site.data.entity.ElementEntity;
import com.gcu.site.data.entity.PurchaseEntity;
import com.gcu.site.model.PurchaseModel;

@Service
public class PurchaseBusinessService implements PurchaseBusinessInterface{
    
    Logger logger = LogManager.getLogger(PurchaseBusinessService.class);

    @Autowired
    private PurchaseDataService service;

    @Autowired
    private ElementDataService elementService;

    @Override
    public List<PurchaseModel> getPurchase() {

        logger.info("entering getPurchase method");

        List<PurchaseEntity> purchaseEntity = service.findAll();

        List<PurchaseModel> purchaseDomain = new ArrayList<PurchaseModel>();

        for (PurchaseEntity entity : purchaseEntity)
        {
            purchaseDomain.add(new PurchaseModel(entity.getID(), entity.getPurchaser(), entity.getItemID(), entity.getItemName(), entity.getQuantity(), entity.getTotalCost()));

        }
        logger.info("exiting getPurchase method");
        return purchaseDomain;
    }

    @Override
    public boolean addPurchase(PurchaseModel purchaseModel) {
        logger.info("entering addPurchase method");

        logger.info("obtaining element information");
        ElementEntity elementModel = elementService.findById(Math.toIntExact(purchaseModel.getItemID()));
        double price = elementModel.getPrice();
        double cost = price * purchaseModel.getQuantity();

        logger.info("adding purchaseEntity:\nPurchaser: " + purchaseModel.getPurchaser() + "\nItem ID: " + purchaseModel.getItemID() + "\nElement Name: " + 
        elementModel.getElementName() + "\nQuantity: " + purchaseModel.getQuantity() + "\nPrice: " + cost);

        PurchaseEntity entity = new PurchaseEntity(null, purchaseModel.getPurchaser(), purchaseModel.getItemID(), elementModel.getElementName(), purchaseModel.getQuantity(), cost);
        
        logger.info("exiting addPurchase method");
        return service.create(entity);
    }

    @Override
    public PurchaseModel getPurchaseById(int id) {
        logger.info("entering getPurchaseById method");
        PurchaseEntity entity = service.findById(id);
        logger.info("found purchaseEntity:\nPurchaser: " + entity.getPurchaser() + "\nItem ID: " + entity.getItemID() + "\nElement Name: " + 
        entity.getItemName() + "\nQuantity: " + entity.getQuantity() + "\nPrice: " + entity.getTotalCost());

        logger.info("exiting getPurchaseById method");
        return new PurchaseModel(entity.getID(), entity.getPurchaser(), entity.getItemID(), entity.getItemName(), entity.getQuantity(), entity.getTotalCost());
    }

    @Override
    public boolean deletePurchase(PurchaseModel purchaseModel) {
        logger.info("entering deletePurchase method");
        
        logger.info("adding purchase entity:\nPurchaser: " + purchaseModel.getPurchaser() + "\nItem ID: " + purchaseModel.getItemID() + "\nElement Name: " + 
        purchaseModel.getItemName() + "\nQuantity: " + purchaseModel.getQuantity() + "\nPrice: " + purchaseModel.getTotalCost());
        PurchaseEntity entity = new PurchaseEntity(purchaseModel.getID(), purchaseModel.getPurchaser(), purchaseModel.getItemID(), purchaseModel.getItemName(), purchaseModel.getQuantity(), purchaseModel.getTotalCost());
        
        logger.info("exiting deletePurchase method");
        return service.delete(entity);
    }

    @Override
    public boolean updatePurchase(PurchaseModel purchaseModel) {
        logger.info("entering updatePurchase method");
        
        logger.info("adding purchase entity:\nPurchaser: " + purchaseModel.getPurchaser() + "\nItem ID: " + purchaseModel.getItemID() + "\nElement Name: " + 
        purchaseModel.getItemName() + "\nQuantity: " + purchaseModel.getQuantity() + "\nPrice: " + purchaseModel.getTotalCost());
        PurchaseEntity entity = new PurchaseEntity(purchaseModel.getID(), purchaseModel.getPurchaser(), purchaseModel.getItemID(), purchaseModel.getItemName(), purchaseModel.getQuantity(), purchaseModel.getTotalCost());
        
        logger.info("exiting updatePurchase method");
        return service.update(entity);
    }
    
}
