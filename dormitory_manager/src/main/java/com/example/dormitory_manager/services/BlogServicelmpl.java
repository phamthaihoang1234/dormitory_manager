
package com.example.dormitory_manager.Services;


import com.example.dormitory_manager.entities.Blog;
import com.example.dormitory_manager.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServicelmpl implements com.example.dormitory_manager.services.BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll(){
        return blogRepository.findAllBlog();
    }
    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }
}
