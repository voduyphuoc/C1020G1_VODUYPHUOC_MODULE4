package com.example.repository.imp;
import com.example.model.Blog;
import com.example.repository.BlogRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public class BlogRepositoryImpl implements BlogRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = em.createQuery("select c from blog c", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(int id) {
        return em.find(Blog.class,id);
    }

    @Override
    public void update(Blog blog) {
        em.persist(blog);
    }

    @Override
    public void remove(int id) {
        Blog blog = findById(id);
        if (blog != null) {
            em.remove(blog);
        }
    }

    @Override
    public void insertProduct(Blog blog) {
        em.merge(blog);
    }
}