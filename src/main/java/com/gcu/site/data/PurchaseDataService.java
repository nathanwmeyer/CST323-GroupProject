package com.gcu.site.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.site.data.entity.PurchaseEntity;
import com.gcu.site.data.repository.PurchaseRepository;

@Service
public class PurchaseDataService implements DataAccessInterface<PurchaseEntity>{

    Logger logger = LogManager.getLogger(PurchaseDataService.class);

    @Autowired
    private PurchaseRepository purchaseRepository;

    @SuppressWarnings("unused")
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public PurchaseDataService(PurchaseRepository purchaseRepository, DataSource dataSource) {
        this.purchaseRepository = purchaseRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<PurchaseEntity> findAll() {
        logger.info("entering findAll method");
        List<PurchaseEntity> purchase = new ArrayList<PurchaseEntity>();

        try
        {
            logger.info("finding all purchases...");
            Iterable<PurchaseEntity> purchaseIterable = purchaseRepository.findAll();

            purchaseIterable.forEach(purchase::add);
        }
        catch (Exception e)
        {
            logger.error("an exception has occurred in findAll()");
            e.printStackTrace();
        }
        logger.info("exiting findAll method");
        return purchase;
    }

    @Override
    public PurchaseEntity findById(int id) {
        logger.warn("this method (findById) is unimplemented and should not appear during use, if this warning has appeared something has gone wrong");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean create(PurchaseEntity t) {
        String sql = "INSERT INTO PURCHASES(PURCHASER, ITEM_ID, ITEM_NAME, QUANTITY, TOTAL_COST) VALUES(?, ?, ?, ?, ?)";
        try
        {
            jdbcTemplateObject.update(sql, t.getPurchaser(), t.getItemID(), t.getItemName(), t.getQuantity(), t.getTotalCost());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(PurchaseEntity t) {
        logger.warn("this method (update) is unimplemented and should not appear during use, if this warning has appeared something has gone wrong");
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(PurchaseEntity t) {
        logger.warn("this method (delete) is unimplemented and should not appear during use, if this warning has appeared something has gone wrong");
        // TODO Auto-generated method stub
        return false;
    }
    
}
