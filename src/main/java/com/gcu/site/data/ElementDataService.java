package com.gcu.site.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.site.data.entity.ElementEntity;
import com.gcu.site.data.repository.ElementRepository;

@Service
public class ElementDataService implements DataAccessInterface<ElementEntity>{

    Logger logger = LogManager.getLogger(ElementDataService.class);

    @Autowired
    private ElementRepository elementRepository;

    @SuppressWarnings("unused")
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public ElementDataService(ElementRepository elementRepository, DataSource dataSource) {
        this.elementRepository = elementRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ElementEntity> findAll() {
        logger.info("entering findAll method");
        List<ElementEntity> element = new ArrayList<ElementEntity>();

        try
        {
            logger.info("finding all elements...");
            Iterable<ElementEntity> elementIterable = elementRepository.findAll();

            elementIterable.forEach(element::add);
        }
        catch (Exception e)
        {
            logger.error("an exception has occurred in findAll()");
            e.printStackTrace();
        }
        logger.info("exiting findAll method");
        return element;
    }

    @Override
    public ElementEntity findById(int id) {
        logger.info("entering findById method");
        logger.info("exiting findById method");
        return elementRepository.getElementByID(id);
    }

    @Override
    public boolean create(ElementEntity t) {
        logger.info("entering create method");
        String sql = "INSERT INTO ELEMENTS(ELEMENT_NAME, ATOMIC_NUM, FORM, DESCRIPTION, RADIOACTIVE, PRICE) VALUES(?, ?, ?, ?, ?, ?)";
        try
        {
            logger.info("attempting to add element to database:\nElement Name: " + t.getElementName() + "\nAtomic Number: " + t.getAtomicNum() + "\nForm: " + t.getForm() + 
            "\nDescription: " + t.getDescription() + "\nRadioactive: " + t.getRadioactive() + "\nPrice: " + t.getPrice());
            jdbcTemplateObject.update(sql, t.getElementName(), t.getAtomicNum(), t.getForm(), t.getDescription(), t.getRadioactive(), t.getPrice());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        logger.info("exiting create method");
        return true;
    }

    @Override
    public boolean update(ElementEntity t) {
        logger.warn("this method (update) is unimplemented and should not appear during use, if this warning has appeared something has gone wrong");
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(ElementEntity t) {
        logger.warn("this method (delete) is unimplemented and should not appear during use, if this warning has appeared something has gone wrong");
        // TODO Auto-generated method stub
        return false;
    }
    
}
