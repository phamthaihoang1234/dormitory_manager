package com.example.dormitory_manager.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.dormitory_manager.entities.Dom;
@EnableJpaRepositories
public interface DomRepository extends JpaRepository<Dom,Long> {
    List<Dom> findBynameOfHotel(String name);
}
