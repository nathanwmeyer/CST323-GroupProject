package com.gcu.site.business;

import java.util.List;

import com.gcu.site.model.PurchaseModel;

public interface PurchaseBusinessInterface {
    public List<PurchaseModel> getPurchase();

    public boolean addPurchase(PurchaseModel purchaseModel);

    public PurchaseModel getPurchaseById(int id);

    public boolean deletePurchase(PurchaseModel purchaseModel);

    public boolean updatePurchase(PurchaseModel purchaseModel);
}
