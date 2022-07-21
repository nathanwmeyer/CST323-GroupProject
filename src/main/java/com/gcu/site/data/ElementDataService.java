package com.gcu.site.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ElementEntity findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean create(ElementEntity t) {
        // TODO Auto-generated method stub
        return false;
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
