package com.gcu.site.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.site.data.entity.ElementEntity;

public interface ElementRepository extends CrudRepository<ElementEntity, Long> {
    ElementEntity getElementByID(int ID);
}
