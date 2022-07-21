package com.gcu.site.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.site.data.entity.PurchaseEntity;
import com.gcu.site.data.repository.PurchaseRepository;

@Service
public class PurchaseDataService implements DataAccessInterface<PurchaseEntity>{

    @Autowired
    private PurchaseRepository purchaseRepository;

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public PurchaseDataService(PurchaseRepository purchaseRepository, DataSource dataSource) {
        this.purchaseRepository = purchaseRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<PurchaseEntity> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PurchaseEntity findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean create(PurchaseEntity t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(PurchaseEntity t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(PurchaseEntity t) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
