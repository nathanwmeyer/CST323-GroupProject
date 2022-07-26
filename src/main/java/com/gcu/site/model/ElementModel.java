package com.gcu.site.model;

public class ElementModel {
    private Long ID;
    private String elementName;
    private int atomicNum;
    private String form;
    private String description;
    private String radioactive;
    private Double price;
    public ElementModel() {
    }

    //Elemement Model method
    public ElementModel(Long iD, String elementName, int atomicNum, String form, String description,
    String radioactive, Double price) {
        ID = iD;
        this.elementName = elementName;
        this.atomicNum = atomicNum;
        this.form = form;
        this.description = description;
        this.radioactive = radioactive;
        this.price = price;
    }
    
    //setters and getters
    public Long getID() {
        return ID;
    }
    public void setID(Long iD) {
        ID = iD;
    }
    public String getElementName() {
        return elementName;
    }
    public void setElementName(String elementName) {
        this.elementName = elementName;
    }
    public int getAtomicNum() {
        return atomicNum;
    }
    public void setAtomicNum(int atomicNum) {
        this.atomicNum = atomicNum;
    }
    public String getForm() {
        return form;
    }
    public void setForm(String form) {
        this.form = form;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getRadioactive() {
        return radioactive;
    }
    public void setRadioactive(String radioactive) {
        this.radioactive = radioactive;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
