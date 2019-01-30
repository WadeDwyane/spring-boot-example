package com.wadedwyane.www.repository.secondary;

import com.wadedwyane.www.entity.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondaryRepository extends MongoRepository<Teacher, Long> {
}
