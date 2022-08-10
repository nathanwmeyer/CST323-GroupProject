package com.gcu.site.business;

import java.util.List;

import com.gcu.site.model.PurchaseModel;

/* This class is an interface class for PurchaseBusinessService */
public interface PurchaseBusinessInterface {
    // Retrieves all purchases in the database
    public List<PurchaseModel> getPurchase();

    // Adds a purchase to the database
    public boolean addPurchase(PurchaseModel purchaseModel);

    // Retrieves a specific purchase from the database
    public PurchaseModel getPurchaseById(int id);

    // Deletes a purchase from the database
    public boolean deletePurchase(PurchaseModel purchaseModel);

    // Updates a purchase in the database
    public boolean updatePurchase(PurchaseModel purchaseModel);
}
