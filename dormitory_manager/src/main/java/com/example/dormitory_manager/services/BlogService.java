
package com.example.dormitory_manager.services;

import com.example.dormitory_manager.entities.Blog;

import java.util.Optional;
public interface BlogService {
    Iterable<Blog> findAll();

    Blog save(Blog province);



    void delete(Long id);

    Optional<Blog> findById(Long id);

}
