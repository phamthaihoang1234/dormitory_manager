package com.example.dormitory_manager.Repository;

import com.example.dormitory_manager.entities.Discount;
import com.example.dormitory_manager.entities.Dom;
import org.springframework.data.repository.CrudRepository;

public interface DiscountRepository extends CrudRepository<Discount,Long> {
}
