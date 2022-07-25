package com.gcu.site.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class PurchaseModel {
    private Long ID;
    private String purchaser;
    private Long itemID;
    private String itemName;
    private Long quantity;
    private Double totalCost;

    public PurchaseModel() {
    }

    public PurchaseModel(Long iD, String purchaser, Long itemID, String itemName, Long quantity, Double totalCost) {
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

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}