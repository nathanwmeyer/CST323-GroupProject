package com.gcu.site.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class PurchaseModel {
    private Long ID;
    private String purchaser;
    private String itemID;
    private String itemName;
    private String quantity;
    private Double totalCost;

    public PurchaseModel() {
    }

    public PurchaseModel(Long iD, String purchaser, String itemID, String itemName, String quantity, Double totalCost) {
        ID = iD;
        this.purchaser = purchaser;
        this.itemID = itemID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.totalCost = totalCost;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        this.ID = iD;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}