package com.example.dormitory_manager.Repository;

import com.example.dormitory_manager.entities.PropertyType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyTypeRepository extends CrudRepository<PropertyType,Long> {
}
