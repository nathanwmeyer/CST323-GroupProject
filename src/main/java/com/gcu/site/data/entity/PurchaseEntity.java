package com.gcu.site.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("PURCHASES")
public class PurchaseEntity {
 
    //Orders/purchases properties
    @Id
    @Column("ID")
    private Long ID;

    @Column("PURCHASER")
    private String purchaser;

    @Column("ITEM_ID")
    private Long itemID;

    @Column("ITEM_NAME")
    private String itemName;

    @Column("QUANTITY")
    private Long quantity;

    @Column("TOTAL_COST")
    private Double totalCost;

    public PurchaseEntity() {
    }

    //Orders/purchases declarations/getters and setters
    public PurchaseEntity(Long iD, String purchaser, Long itemID, String itemName, Long quantity, Double totalCost) {
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
