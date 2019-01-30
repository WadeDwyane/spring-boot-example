package com.wadedwyane.www.repository.primary;

import com.wadedwyane.www.entity.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryRepository extends MongoRepository<Teacher, Long> {


}
