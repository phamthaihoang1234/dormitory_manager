package com.example.dormitory_manager.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dormitory_manager.Repository.DomRepository;
import com.example.dormitory_manager.entities.Dom;
import com.example.dormitory_manager.entities.ResponseObject;


@RestController
@RequestMapping(path = "/api/v1/Dom")
public class DomController {
    @Autowired
    private DomRepository domRepository;

    @GetMapping("")
    List<Dom> getAllDoms() {
        return domRepository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Dom> foundDom = domRepository.findById(id);
        if (foundDom.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query product successfully", foundDom.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false", "Cannot find product with id= " + id, null));
        }
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertDom(@RequestBody Dom newDom) {
        List<Dom> foundProducts = domRepository.findBynameOfHotel(newDom.getNameOfHotel().trim());
        if (foundProducts.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "insert product duplicated", ""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(

                new ResponseObject("ok", "insert product successfully", domRepository.save(newDom)));
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateDom(@RequestBody Dom newDom, @PathVariable Long id) {
        Dom updatedDom = domRepository.findById(id).map(dom -> {
            dom.setNameOfHotel(newDom.getNameOfHotel());
            dom.setStatus(newDom.getStatus());
            dom.setAddressOfHotel(newDom.getAddressOfHotel());
            dom.setIframe(newDom.getIframe());
            return domRepository.save(dom);
        }).orElseGet(() -> {
            newDom.setId(id);
            return domRepository.save(newDom);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject("ok", "update product successfully", updatedDom)
        );
    }
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteDom(@PathVariable Long id){
        boolean exits = domRepository.existsById(id);
        if(exits){
            domRepository.deleteById(id);;
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "delete product successfully","")

            );
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("failed", "Cannot find product","")

            );
        }
    }
    
}

