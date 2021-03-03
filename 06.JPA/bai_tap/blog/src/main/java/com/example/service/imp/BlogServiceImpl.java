package com.example.service.imp;

import com.example.model.Blog;
import com.example.repository.BlogRepository;
import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.update(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.remove(id);
    }

    @Override
    public void insertProduct(Blog blog) {
        blogRepository.insertProduct(blog);
    }
}
