package com.gcu.site.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.site.data.entity.PurchaseEntity;

public interface PurchaseRepository extends CrudRepository<PurchaseEntity, Long>{
    
}
