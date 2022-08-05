package com.gcu.site.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.site.data.ElementDataService;
import com.gcu.site.data.entity.ElementEntity;
import com.gcu.site.model.ElementModel;

@Service
public class ElementBusinessService implements ElementBusinessInterface{
    
    Logger logger = LogManager.getLogger(ElementBusinessService.class);

    @Autowired
    private ElementDataService service;

    @Override
    public List<ElementModel> getElement() {
        logger.info("entering getElement method");
        List<ElementEntity> elementEntity = service.findAll();

        List<ElementModel> elementDomain = new ArrayList<ElementModel>();

        for (ElementEntity entity : elementEntity)
        {
            elementDomain.add(new ElementModel(entity.getID(), entity.getElementName(), entity.getAtomicNum(), entity.getForm(), entity.getDescription(), entity.getRadioactive(), entity.getPrice()));

        }

        logger.info("exiting getElement method");
        return elementDomain;
    }

    @Override
    public boolean addElement(ElementModel elementModel) {
        logger.info("entering addElement method");

        logger.info("adding element: \nName: " + elementModel.getElementName() + "\nAtomic Number: " + elementModel.getAtomicNum() + "\nForm: " + elementModel.getForm() + 
        "\nDescription: " + elementModel.getDescription() + "\nRadioactivity: " + elementModel.getRadioactive() + "\nPrice: " + elementModel.getPrice());
        ElementEntity entity = new ElementEntity(null, elementModel.getElementName(), elementModel.getAtomicNum(), elementModel.getForm(), elementModel.getDescription(), elementModel.getRadioactive(), elementModel.getPrice());
        logger.info("exiting addElement method");
        return service.create(entity);
    }

    @Override
    public ElementModel getElementById(int id) {
        logger.info("entering getElementById method");

        ElementEntity entity = service.findById(id);
        logger.info("retrieved element: \nName: " + entity.getElementName() + "\nAtomic Number: " + entity.getAtomicNum() + "\nForm: " + entity.getForm() + 
        "\nDescription: " + entity.getDescription() + "\nRadioactivity: " + entity.getRadioactive() + "\nPrice: " + entity.getPrice());

        logger.info("exiting getElementById method");
        return new ElementModel(entity.getID(), entity.getElementName(), entity.getAtomicNum(), entity.getForm(), entity.getDescription(), entity.getRadioactive(), entity.getPrice());
    }

    @Override
    public boolean deleteElement(ElementModel elementModel) {
        logger.info("entering deleteElement method");

        logger.info("removing element: \nName: " + elementModel.getElementName() + "\nAtomic Number: " + elementModel.getAtomicNum() + "\nForm: " + elementModel.getForm() + 
        "\nDescription: " + elementModel.getDescription() + "\nRadioactivity: " + elementModel.getRadioactive() + "\nPrice: " + elementModel.getPrice());
        ElementEntity entity = new ElementEntity(elementModel.getID(), elementModel.getElementName(), elementModel.getAtomicNum(), elementModel.getForm(), elementModel.getDescription(), elementModel.getRadioactive(), elementModel.getPrice());
        
        logger.info("exiting deleteElement method");
        return service.delete(entity);
    }

    @Override
    public boolean updateElement(ElementModel elementModel) {
        logger.info("entering updateElement method");

        logger.info("updating element: \nName: " + elementModel.getElementName() + "\nAtomic Number: " + elementModel.getAtomicNum() + "\nForm: " + elementModel.getForm() + 
        "\nDescription: " + elementModel.getDescription() + "\nRadioactivity: " + elementModel.getRadioactive() + "\nPrice: " + elementModel.getPrice());
        ElementEntity entity = new ElementEntity(elementModel.getID(), elementModel.getElementName(), elementModel.getAtomicNum(), elementModel.getForm(), elementModel.getDescription(), elementModel.getRadioactive(), elementModel.getPrice());
        
        logger.info("exiting updateElement method");
        return service.delete(entity);
    }
    
}
