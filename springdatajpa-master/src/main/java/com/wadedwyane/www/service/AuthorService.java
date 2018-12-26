package com.wadedwyane.www.service;

import com.wadedwyane.www.entity.Author;
import com.wadedwyane.www.impl.IAuthorService;
import com.wadedwyane.www.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    @CachePut(cacheNames = "author")
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    @Cacheable(value = "author", key = "#id")
    public Author findById(Long id) {
        Author author = authorRepository.findById(id).get();
        return author;
    }

    @Override
    @Cacheable(value = "authorList")
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @CacheEvict(value = "author", allEntries = true)
    public void clearCache() {

    }

    @CacheEvict(value = "author")
    public void clean(Long id) {

    }


}
