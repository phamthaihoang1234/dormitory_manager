package com.example.dormitory_manager.Repository;

import com.example.dormitory_manager.entities.Dom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomRepository extends CrudRepository<Dom,Long> {
    @Query(value = "SELECT * FROM hotel where user_id = ?1", nativeQuery = true)
    Iterable<Dom> findAllDomByUserId(long id);
}
