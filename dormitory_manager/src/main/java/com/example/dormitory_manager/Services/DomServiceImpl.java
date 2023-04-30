package com.example.dormitory_manager.Services;

import com.example.dormitory_manager.Repository.DomRepository;
import com.example.dormitory_manager.entities.Dom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DomServiceImpl implements DomService{
    @Autowired
    private DomRepository domRepository;

    @Override
    public Iterable<Dom> findAll() {
        return domRepository.findAll();
    }

    @Override
    public Iterable<Dom> findAllDomByUserId(long id) {
        return domRepository.findAllDomByUserId(id);
    }

    @Override
    public Optional<Dom> findById(Long id) {
        return domRepository.findById(id);
    }

    @Override
    public Dom save(Dom province) {
        return domRepository.save(province);
    }

    @Override
    public void delete(Long id) {
        domRepository.deleteById(id);
    }
}
