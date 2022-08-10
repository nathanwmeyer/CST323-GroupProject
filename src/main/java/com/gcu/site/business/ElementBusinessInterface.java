package com.gcu.site.business;

import java.util.List;

import com.gcu.site.model.ElementModel;

/* This class is an interface class for ElementBusinessService */
public interface ElementBusinessInterface {
    // Retrieves all Elements from the database
    public List<ElementModel> getElement();

    // Adds Element to the database
    public boolean addElement(ElementModel elementModel);

    // Retrieves an Element from the database by using its ID
    public ElementModel getElementById(int id);

    // Removes an Element from the database
    public boolean deleteElement(ElementModel elementModel);

    // Updates an Element in the database
    public boolean updateElement(ElementModel elementModel);
}
