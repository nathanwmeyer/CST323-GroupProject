package com.gcu.site.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ELEMENTS")
public class ElementEntity {

    @Id
    @Column("ID")
    private Long ID;

    @Column("ELEMENT_NAME")
    private String elementName;

    @Column("ATOMIC_NUM")
    private int atomicNum;
    
    @Column("FORM")
    private String form;
    
    @Column("DESCRIPTION")
    private String description;
    
    @Column("RADIOACTIVE")
    private String radioactive;
    
    @Column("PRICE")
    private Double price;


    public ElementEntity() {
    }
    public ElementEntity(Long iD, String elementName, int atomicNum, String form, String description,
    String radioactive, Double price) {
        ID = iD;
        this.elementName = elementName;
        this.atomicNum = atomicNum;
        this.form = form;
        this.description = description;
        this.radioactive = radioactive;
        this.price = price;
    }
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
