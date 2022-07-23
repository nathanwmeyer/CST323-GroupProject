package com.gcu.site.business;

import java.util.List;

import com.gcu.site.model.ElementModel;

public interface ElementBusinessInterface {
    public List<ElementModel> getElement();

    public boolean addElement(ElementModel elementModel);

    public ElementModel getElementById(int id);

    public boolean deleteElement(ElementModel elementModel);

    public boolean updateElement(ElementModel elementModel);
}
