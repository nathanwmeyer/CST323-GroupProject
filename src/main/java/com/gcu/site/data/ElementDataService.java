package com.gcu.site.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import com.gcu.site.data.entity.ElementEntity;
import com.gcu.site.data.repository.ElementRepository;

@Service
public class ElementDataService implements DataAccessInterface<ElementEntity>{

    @Autowired
    private ElementRepository elementRepository;

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public ElementDataService(ElementRepository elementRepository, DataSource dataSource) {
        this.elementRepository = elementRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ElementEntity> findAll() {
        List<ElementEntity> element = new ArrayList<ElementEntity>();

        try
        {
            Iterable<ElementEntity> elementIterable = elementRepository.findAll();

            elementIterable.forEach(element::add);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return element;
    }

    @Override
    public ElementEntity findById(int id) {
        return elementRepository.getElementByID(id);
    }

    @Override
    public boolean create(ElementEntity t) {
        String sql = "INSERT INTO ELEMENTS(ELEMENT_NAME, ATOMIC_NUM, FORM, DESCRIPTION, RADIOACTIVE, PRICE) VALUES(?, ?, ?, ?, ?, ?)";
        try
        {
            jdbcTemplateObject.update(sql, t.getElementName(), t.getAtomicNum(), t.getForm(), t.getDescription(), t.getRadioactive(), t.getPrice());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(ElementEntity t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(ElementEntity t) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
