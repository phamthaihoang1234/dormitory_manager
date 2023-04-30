package com.example.dormitory_manager.Services;

import com.example.dormitory_manager.entities.Dom;

import java.util.Optional;

public interface DomService {
    Iterable<Dom> findAll();

    Dom save(Dom province);

    Iterable<Dom> findAllDomByUserId(long id);

    void delete(Long id);

    Optional<Dom> findById(Long id);
}
