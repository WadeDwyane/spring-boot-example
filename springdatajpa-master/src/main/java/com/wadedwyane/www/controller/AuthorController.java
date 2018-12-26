package com.wadedwyane.www.controller;


import com.wadedwyane.www.entity.Author;
import com.wadedwyane.www.mapper.AuthorMapper;
import com.wadedwyane.www.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @Autowired
    AuthorMapper authorMapper;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestParam(value = "name") String name, @RequestParam(value = "age") Integer age,
                     @RequestParam(value = "bookName") String bookName) {
        Author author = new Author();
        author.setName(name);
        author.setAge(age);
        author.setBookName(bookName);
        authorService.save(author);
    }

    @RequestMapping(value = "/findAuthor", method = RequestMethod.GET)
    public Author findById(@RequestParam(value = "id") Long id) {
        return authorService.findById(id);
    }

    @RequestMapping(value = "/findAll")
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public void insert(@RequestParam(value = "name")String name,
                       @RequestParam(value = "age")int age,
                       @RequestParam(value = "bookName")String bookName) {
        Author author = new Author();
        author.setName(name);
        author.setAge(age);
        author.setBookName(bookName);
        authorMapper.insert(author);
    }
}
