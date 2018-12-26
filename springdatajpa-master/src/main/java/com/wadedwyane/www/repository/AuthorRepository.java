package com.wadedwyane.www.repository;

import com.wadedwyane.www.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>,JpaSpecificationExecutor<Author> {
}
