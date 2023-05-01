package com.example.dormitory_manager.Repository;

import com.example.dormitory_manager.entities.Dom;
import com.example.dormitory_manager.entities.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomRepository extends CrudRepository<Dom,Long> {
    @Query(value = "SELECT * FROM dom where status = 1", nativeQuery = true)
    Iterable<Dom> findAllDomAvailable();



}
