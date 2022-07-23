package com.gcu.site.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.site.data.ElementDataService;
import com.gcu.site.data.entity.ElementEntity;
import com.gcu.site.model.ElementModel;

@Service
public class ElementBusinessService implements ElementBusinessInterface{

    @Autowired
    private ElementDataService service;

    @Override
    public List<ElementModel> getElement() {
        List<ElementEntity> elementEntity = service.findAll();

        List<ElementModel> elementDomain = new ArrayList<ElementModel>();

        for (ElementEntity entity : elementEntity)
        {
            elementDomain.add(new ElementModel(entity.getID(), entity.getElementName(), entity.getAtomicNum(), entity.getForm(), entity.getDescription(), entity.getRadioactive(), entity.getPrice()));

        }

        return elementDomain;
    }

    @Override
    public boolean addElement(ElementModel elementModel) {
        ElementEntity entity = new ElementEntity(null, elementModel.getElementName(), elementModel.getAtomicNum(), elementModel.getForm(), elementModel.getDescription(), elementModel.getRadioactive(), elementModel.getPrice());
        return service.create(entity);
    }

    @Override
    public ElementModel getElementById(int id) {
        ElementEntity entity = service.findById(id);
        return new ElementModel(entity.getID(), entity.getElementName(), entity.getAtomicNum(), entity.getForm(), entity.getDescription(), entity.getRadioactive(), entity.getPrice());
    }

    @Override
    public boolean deleteElement(ElementModel elementModel) {
        ElementEntity entity = new ElementEntity(elementModel.getID(), elementModel.getElementName(), elementModel.getAtomicNum(), elementModel.getForm(), elementModel.getDescription(), elementModel.getRadioactive(), elementModel.getPrice());
        return service.delete(entity);
    }

    @Override
    public boolean updateElement(ElementModel elementModel) {
        ElementEntity entity = new ElementEntity(elementModel.getID(), elementModel.getElementName(), elementModel.getAtomicNum(), elementModel.getForm(), elementModel.getDescription(), elementModel.getRadioactive(), elementModel.getPrice());
        return service.delete(entity);
    }
    
}
