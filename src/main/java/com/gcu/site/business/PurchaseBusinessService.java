package com.gcu.site.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.site.data.ElementDataService;
import com.gcu.site.data.PurchaseDataService;
import com.gcu.site.data.entity.ElementEntity;
import com.gcu.site.data.entity.PurchaseEntity;
import com.gcu.site.model.ElementModel;
import com.gcu.site.model.PurchaseModel;

@Service
public class PurchaseBusinessService implements PurchaseBusinessInterface{

    @Autowired
    private PurchaseDataService service;

    @Autowired
    private ElementDataService elementService;

    @Override
    public List<PurchaseModel> getPurchase() {
        List<PurchaseEntity> purchaseEntity = service.findAll();

        List<PurchaseModel> purchaseDomain = new ArrayList<PurchaseModel>();

        for (PurchaseEntity entity : purchaseEntity)
        {
            purchaseDomain.add(new PurchaseModel(entity.getID(), entity.getPurchaser(), entity.getItemID(), entity.getItemName(), entity.getQuantity(), entity.getTotalCost()));

        }

        return purchaseDomain;
    }

    @Override
    public boolean addPurchase(PurchaseModel purchaseModel) {
        ElementEntity elementModel = elementService.findById(Math.toIntExact(purchaseModel.getItemID()));
        double price = elementModel.getPrice();
        double cost = price * purchaseModel.getQuantity();

        PurchaseEntity entity = new PurchaseEntity(null, purchaseModel.getPurchaser(), purchaseModel.getItemID(), elementModel.getElementName(), purchaseModel.getQuantity(), cost);
        return service.create(entity);
    }

    @Override
    public PurchaseModel getPurchaseById(int id) {
        PurchaseEntity entity = service.findById(id);
        return new PurchaseModel(entity.getID(), entity.getPurchaser(), entity.getItemID(), entity.getItemName(), entity.getQuantity(), entity.getTotalCost());
    }

    @Override
    public boolean deletePurchase(PurchaseModel purchaseModel) {
        PurchaseEntity entity = new PurchaseEntity(purchaseModel.getID(), purchaseModel.getPurchaser(), purchaseModel.getItemID(), purchaseModel.getItemName(), purchaseModel.getQuantity(), purchaseModel.getTotalCost());
        return service.delete(entity);
    }

    @Override
    public boolean updatePurchase(PurchaseModel purchaseModel) {
        PurchaseEntity entity = new PurchaseEntity(purchaseModel.getID(), purchaseModel.getPurchaser(), purchaseModel.getItemID(), purchaseModel.getItemName(), purchaseModel.getQuantity(), purchaseModel.getTotalCost());
        return service.update(entity);
    }
    
}
