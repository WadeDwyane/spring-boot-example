package com.wadedwyane.www.impl;

import com.wadedwyane.www.entity.Author;

import java.util.List;

public interface IAuthorService {

    Author save(Author author);

    Author findById(Long id);

    List<Author> findAll();
}
